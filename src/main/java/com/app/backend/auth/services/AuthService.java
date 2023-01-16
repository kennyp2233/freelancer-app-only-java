package com.app.backend.auth.services;

import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.auth.entities.AuthEntity;
import com.app.backend.auth.repositories.AuthRepository;
import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.EmailAlreadyExistsException;
import com.app.backend.common.errors.EmailMismatchException;
import com.app.backend.common.errors.InvalidCredentialsException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.utils.Generator;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.services.UsersService;

public class AuthService {
  private static AuthService instance;
  private AuthRepository repository;
  private UsersService usersService;

  private AuthService(AuthRepository repository, UsersService usersService) {
    this.repository = repository;
    this.usersService = usersService;
  }

  public static void initInstance(AuthRepository repository, UsersService usersService) {
    if (instance == null) {
      instance = new AuthService(repository, usersService);
    }
  }

  public static AuthService getInstance() {
    if (instance == null) {
      throw new RuntimeException("Auth Service not initialized");
    }
    return instance;
  }

  public UserEntity validateCredentials(String email, String password)
      throws InvalidCredentialsException, NotFoundException {
    AuthEntity authData;
    UserEntity user;

    authData = repository.getByEmail(email);

    if (authData == null) {
      throw new InvalidCredentialsException();
    }

    if (!authData.getPassword().equals(password)) {
      throw new InvalidCredentialsException();
    }

    user = this.usersService.getByEmail(email);

    return user;
  }

  public UserEntity register(AuthDTO createAuthDTO, UserDTO createUserDTO)
      throws EmailAlreadyExistsException, BadRequestException, EmailMismatchException {
    AuthEntity newAuthUser;
    UserDTO creaUserDTO;
    UserEntity newUser;

    if (!createAuthDTO.isCreateDTO()) {
      throw new BadRequestException();
    }

    if (!createUserDTO.isCreateUserDTO()) {
      throw new BadRequestException();
    }

    if (!createAuthDTO.getEmail().equals(createUserDTO.getEmail())) {
      throw new EmailMismatchException();
    }

    if (repository.getByEmail(createAuthDTO.getEmail()) != null) {
      throw new EmailAlreadyExistsException();
    }

    String id = Generator.generateId();

    newAuthUser = new AuthEntity(id, createAuthDTO);
    repository.insert(newAuthUser);

    creaUserDTO = new UserDTO(createUserDTO);
    newUser = this.usersService.create(creaUserDTO);

    return newUser;
  }
}

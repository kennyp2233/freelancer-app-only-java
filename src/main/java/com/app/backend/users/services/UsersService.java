package com.app.backend.users.services;

import java.util.ArrayList;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.utils.Generator;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class UsersService {
  private UsersRepository repository;
  private static UsersService instance = null;

  private UsersService(UsersRepository repository) {
    this.repository = repository;
  }

  public static void initInstance(UsersRepository repository) {
    if (instance == null) {
      instance = new UsersService(repository);
    }
  }

  public static UsersService getInstance() {
    if (instance == null) {
      throw new RuntimeException("Users Service not initialized");
    }
    return instance;
  }

  public UserEntity create(UserDTO userDTO) throws BadRequestException {
    String id;
    UserEntity newUser;

    // If userDTO is not valid, throws BadRequestException
    if (!userDTO.isCreateUserDTO()) {
      throw new BadRequestException();
    }

    id = Generator.generateId();

    newUser = new UserEntity(id, userDTO);

    this.repository.insert(newUser);

    return newUser;
  }

  public ArrayList<UserEntity> getAll() {
    return this.repository.getAll();
  }

  public UserEntity getById(String id) throws NotFoundException {
    UserEntity user;

    user = this.repository.getById(id);

    if (user == null) {
      throw new NotFoundException();
    }

    return user;
  }

  public UserEntity getByEmail(String email) throws NotFoundException {
    UserEntity user;

    user = this.repository.getByEmail(email);

    if (user == null) {
      throw new NotFoundException();
    }

    return user;
  }

  public UserEntity update(String id, UserDTO userDTO) throws NotFoundException, BadRequestException {
    UserEntity userUpdated;

    if (!userDTO.isUpdateUserDTO()) {
      throw new BadRequestException();
    }

    // If id not found, throws NotFoundException
    this.getById(id);

    userUpdated = this.repository.update(id, userDTO);

    return userUpdated;
  }

  public UserEntity delete(String id) throws NotFoundException {
    UserEntity userDeleted;

    // If id not found, throws NotFoundException
    this.getById(id);

    userDeleted = this.repository.delete(id);

    return userDeleted;
  }
}

package com.app.backend.auth;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.xml.crypto.Data;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.auth.controllers.AuthController;
import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.EmailAlreadyExistsException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.database.Database;
import com.app.backend.users.UsersModule;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;

public class AuthModuleTest {
  private UsersModule usersModule;
  private AuthModule authModule;

  private AuthController authController;

  private Database database;

  @Before
  public void setUp() throws EmailAlreadyExistsException, BadRequestException {
    // Init Database
    Database.connect();
    this.database = Database.getInstance();

    // Init User Module
    UsersModule.initInstance(this.database);
    this.usersModule = UsersModule.getInstance();

    // Init Auth Module
    AuthModule.initInstance(this.database, this.usersModule);
    this.authModule = AuthModule.getInstance();

    authController = this.authModule.getAuthController();
  }

  @Test
  public void shouldCreateUser() throws NotFoundException {
    AuthDTO createAuthDTO;
    UserDTO creaUserDTO;
    Response response;
    UserEntity newUser;
    UserEntity expectedUser;

    createAuthDTO = new AuthDTO("alex@mail.com", "123456789");
    creaUserDTO = new UserDTO("Alex", createAuthDTO.getEmail());

    response = authController.register(createAuthDTO, creaUserDTO);
    newUser = (UserEntity) response.getData();

    expectedUser = usersModule.getUsersService().getByEmail(createAuthDTO.getEmail());

    assertEquals(expectedUser, newUser);
  }

  @Test
  public void shouldLoginUser() throws NotFoundException, EmailAlreadyExistsException, BadRequestException {
    AuthDTO authDTO;
    Response response;
    UserEntity expectedUser;
    UserEntity authUser;

    this.authModule.getAuthService().register(new AuthDTO("erick@mail.com", "11111111"),
        new UserDTO("Erick", "erick@mail.com"));

    authDTO = new AuthDTO("erick@mail.com", "11111111");

    // Logging user
    response = authController.login(authDTO.getEmail(), authDTO.getPassword());
    authUser = (UserEntity) response.getData();

    expectedUser = usersModule.getUsersService().getByEmail(authDTO.getEmail());

    assertEquals(expectedUser, authUser);
  }

  @Test
  public void shouldNotLoggingByInvalidCredentials() throws EmailAlreadyExistsException, BadRequestException {
    AuthDTO authDTO;
    Response response;
    Response expectedResponse;

    this.authModule.getAuthService().register(new AuthDTO("kenny@mail.com", "22222222"),
        new UserDTO("Kenny", "kenny@mail.com"));

    authDTO = new AuthDTO("erick@mail.com", "111111111");

    // Logging user
    response = authController.login(authDTO.getEmail(), authDTO.getPassword());

    expectedResponse = new ErrorResponse("Invalid Credentials");

    assertEquals(expectedResponse, response);
  }
}

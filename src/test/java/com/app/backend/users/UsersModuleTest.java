package com.app.backend.users;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SuccessResponse;
import com.app.backend.database.Database;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;

public class UsersModuleTest {
  private UsersModule usersModule;
  private UsersController usersController;
  private Database database;

  @Before
  public void setUp() throws BadRequestException {
    // Init Database
    Database.connect();
    this.database = Database.getInstance();

    // Init User Module
    UsersModule.initInstance(this.database);
    this.usersModule = UsersModule.getInstance();

    this.usersModule.getUsersService().create(new UserDTO("Cristian",
        "cristian@mail.com"));
    this.usersModule.getUsersService().create(new UserDTO("Cristina",
        "cristina@mail.com"));

    this.usersController = this.usersModule.getUsersController();
  }

  @Test
  public void shouldCreateUser() {
    UserDTO createUserDTO;
    Response response;
    UserEntity newUser;
    UserEntity expectedUser;

    createUserDTO = new UserDTO("Alex", "alex@mail.com");
    response = usersController.create(createUserDTO);
    newUser = (UserEntity) response.getData();

    expectedUser = new UserEntity(newUser.getId(), "Alex", "alex@mail.com");

    assertEquals(expectedUser, newUser);
  }

  @Test
  public void shouldGetUser() {
    UserDTO createUserDTO;
    Response response;
    UserEntity user;
    UserEntity expectedUser;

    createUserDTO = new UserDTO("Julio Sandobalin", "julio@mail.com");
    response = usersController.create(createUserDTO);
    expectedUser = (UserEntity) response.getData();

    response = usersController.getById(expectedUser.getId());
    user = (UserEntity) response.getData();

    assertEquals(expectedUser, user);
  }

  @Test
  public void shouldUpdateUser() {
    UserDTO createUserDTO;
    UserDTO updateUserDTO;
    Response response;
    Response expectedResponse;
    UserEntity userToUpdate;
    UserEntity expectedUser;

    // Create user to update
    createUserDTO = new UserDTO("Johan Mantilla", "johan@mail.com");
    response = usersController.create(createUserDTO);
    userToUpdate = (UserEntity) response.getData();

    // Update user
    updateUserDTO = new UserDTO("Roberto Mantilla", "roberto@gmail.com");
    response = usersController.update(userToUpdate.getId(), updateUserDTO);

    expectedUser = new UserEntity(userToUpdate.getId(), "Roberto Mantilla", "roberto@gmail.com");
    expectedResponse = new SuccessResponse("User updated", expectedUser);

    assertEquals(expectedResponse, response);
  }

  @Test(expected = NotFoundException.class)
  public void shouldDeleteUser() throws NotFoundException {
    Response response;
    Response expectedResponse;
    UserEntity deletedUser;
    UserEntity userToDeleted;

    // Create user to delete
    userToDeleted = (UserEntity) (this.usersController.create(new UserDTO("Alex", "alex@mail.com"))).getData();

    // Delete user
    deletedUser = this.usersModule.getUsersService().getById(userToDeleted.getId());
    response = usersController.delete(userToDeleted.getId());

    expectedResponse = new SuccessResponse("User deleted", deletedUser);

    assertEquals(expectedResponse, response);

    // Get user again to check if it was deleted (should throw NotFoundException)
    this.usersModule.getUsersService().getById(userToDeleted.getId());
  }
}

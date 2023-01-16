package com.app.frontend.components.users;

import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.UserInput;
import com.app.frontend.services.UsersServiceUI;

public class UsersComponentUI {
  private UsersServiceUI usersServicesUI;
  private UserInput userInput;
  private UserEntity admin;

  public UsersComponentUI(UserEntity admin, UsersServiceUI usersServicesUI) {
    this.userInput = new UserInput();
    this.usersServicesUI = usersServicesUI;
    this.admin = admin;
  }

  public void create() {
    Response response;
    UserDTO createUserDTO;

    // Create user dto from user input
    createUserDTO = this.userInput.readUserDTO();

    // Response from users service UI
    response = this.usersServicesUI.create(createUserDTO);

    // Print response
    System.out.println(response);
  }

  public void getById() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.getUserById(userId);

    System.out.println(response);
  }

  public void getAll() {
    Response response;

    response = this.usersServicesUI.getAll();

    System.out.println(response);
  }

  public void update() {
    Response response;
    String userId;
    UserDTO updateUserDTO;

    userId = this.userInput.readString("Enter the user id:");
    updateUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.update(userId, updateUserDTO);

    System.out.println(response);
  }

  public void delete() {
    Response response;
    String userId;

    userId = this.userInput.readString("Enter the user id:");

    response = this.usersServicesUI.delete(userId);

    System.out.println(response);
  }
}

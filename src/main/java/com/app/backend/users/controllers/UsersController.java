package com.app.backend.users.controllers;

import java.util.ArrayList;

import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SuccessResponse;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.services.UsersService;

public class UsersController {
  private static UsersController instance = null;
  private UsersService usersService;

  private UsersController(UsersService usersService) {
    this.usersService = usersService;
  }

  public static void initInstance(UsersService usersService) {
    if (instance == null) {
      instance = new UsersController(usersService);
    }
  }

  public static UsersController getInstance() {
    if (instance == null) {
      throw new RuntimeException("Users Controller not initialized");
    }
    return instance;
  }

  public Response create(UserDTO userDTO) {
    UserEntity user;
    Response response;

    try {
      user = this.usersService.create(userDTO);

      response = new SuccessResponse("User created", user);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response getAll() {
    ArrayList<UserEntity> users;
    Response response;

    try {
      users = this.usersService.getAll();
      response = new SuccessResponse("OK", users);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response getById(String id) {
    UserEntity user;
    Response response;

    try {
      user = this.usersService.getById(id);
      response = new SuccessResponse("User found", user);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response update(String id, UserDTO userDTO) {
    UserEntity user;
    Response response;

    try {
      user = this.usersService.update(id, userDTO);
      response = new SuccessResponse("User updated", user);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response delete(String id) {
    UserEntity user;
    Response response;

    try {
      user = this.usersService.delete(id);
      response = new SuccessResponse("User deleted", user);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

}

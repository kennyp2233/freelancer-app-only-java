package com.app.frontend.services;

import com.app.backend.common.responses.Response;
import com.app.backend.users.controllers.UsersController;
import com.app.backend.users.dtos.UserDTO;

public class UsersServiceUI {
  private UsersController usersController;

  public UsersServiceUI(UsersController usersController) {
    this.usersController = usersController;
  }

  public Response create(UserDTO creaUserDTO) {
    Response response;
    response = this.usersController.create(creaUserDTO);

    return response;
  }

  public Response getUserById(String userId) {
    Response response;
    response = this.usersController.getById(userId);

    return response;
  }

  public Response getAll() {
    Response response;
    response = this.usersController.getAll();

    return response;
  }

  public Response update(String userId, UserDTO updateUserDTO) {
    Response response;
    response = this.usersController.update(userId, updateUserDTO);

    return response;
  }

  public Response delete(String userId) {
    Response response;
    response = this.usersController.delete(userId);

    return response;
  }
}

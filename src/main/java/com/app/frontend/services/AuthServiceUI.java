package com.app.frontend.services;

import com.app.backend.auth.controllers.AuthController;
import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;

public class AuthServiceUI {
  AuthController authController;

  public AuthServiceUI(AuthController authController) {
    this.authController = authController;
  }

  public Response login(String email, String password) {
    Response response;

    response = this.authController.login(email, password);

    return response;
  }

  public Response register(AuthDTO createAuthDTO, UserDTO creaUserDTO) {
    Response response;

    response = this.authController.register(createAuthDTO, creaUserDTO);

    return response;
  }
}

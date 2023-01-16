package com.app.backend.auth.controllers;

import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.auth.services.AuthService;
import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SuccessResponse;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;

public class AuthController {
  private static AuthController instance = null;
  private AuthService authService;

  private AuthController(AuthService authService) {
    this.authService = authService;
  }

  public static void initInstance(AuthService authService) {
    if (instance == null) {
      instance = new AuthController(authService);
    }
  }

  public static AuthController getInstance() {
    if (instance == null) {
      throw new RuntimeException("Auth Controller not initialized");
    }
    return instance;
  }

  public Response login(String email, String password) {
    Response response;
    UserEntity authUser;

    try {
      authUser = authService.validateCredentials(email, password);
      response = new SuccessResponse("Successfully login", authUser);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response register(AuthDTO createAuthDTO, UserDTO creaUserDTO) {
    Response response;
    UserEntity newUser;

    try {
      newUser = authService.register(createAuthDTO, creaUserDTO);
      response = new SuccessResponse("Successfully registered", newUser);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }
}

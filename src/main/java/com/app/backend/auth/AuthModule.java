package com.app.backend.auth;

import com.app.backend.auth.controllers.AuthController;
import com.app.backend.auth.repositories.AuthRepository;
import com.app.backend.auth.services.AuthService;
import com.app.backend.database.Database;
import com.app.backend.users.UsersModule;
import com.app.backend.users.services.UsersService;

public class AuthModule {
  private AuthController authController;
  private AuthService authService;
  private AuthRepository authRepository;

  private static AuthModule instance = null;

  private AuthModule(Database database, UsersService usersService) {
    AuthRepository.initInstance(database);
    this.authRepository = AuthRepository.getInstance();

    AuthService.initInstance(this.authRepository, usersService);
    this.authService = AuthService.getInstance();

    AuthController.initInstance(authService);
    this.authController = AuthController.getInstance();
  }

  public static void initInstance(Database database, UsersModule usersModule) {
    instance = new AuthModule(database, usersModule.getUsersService());
  }

  public static AuthModule getInstance() {
    if (instance == null) {
      throw new RuntimeException("Auth Module not initialized");
    }
    return instance;
  }

  public AuthService getAuthService() {
    return authService;
  }

  public AuthController getAuthController() {
    return authController;
  }
}

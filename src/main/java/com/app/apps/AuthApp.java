package com.app.apps;

import com.app.backend.auth.AuthModule;
import com.app.backend.database.Database;
import com.app.backend.users.UsersModule;
import com.app.frontend.modules.AuthModuleUI;

public class AuthApp {
  private AuthModule authModule;
  private AuthModuleUI authModuleUI;

  public AuthApp(Database database, UsersModule usersModule) {
    // Auth Module Instance (Backend)
    AuthModule.initInstance(database, usersModule);
    this.authModule = AuthModule.getInstance();

    // Auth Module UI Instance (Frontend)
    this.authModuleUI = new AuthModuleUI(this.authModule.getAuthController());
  }

  public AuthModule getAuthModule() {
    return this.authModule;
  }

  public AuthModuleUI getAuthModuleUI() {
    return this.authModuleUI;
  }
}

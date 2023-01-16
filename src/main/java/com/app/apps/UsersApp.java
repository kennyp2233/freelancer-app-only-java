package com.app.apps;

import com.app.backend.database.Database;
import com.app.backend.users.UsersModule;
import com.app.frontend.modules.UsersModuleUI;

public class UsersApp {
  private UsersModule usersModule;
  private UsersModuleUI usersModuleUI;

  public UsersApp(Database database) {
    // Users Module Instance (Backend)
    UsersModule.initInstance(database);
    this.usersModule = UsersModule.getInstance();

    // Users Module UI Instance (Frontend)
    this.usersModuleUI = new UsersModuleUI(this.usersModule.getUsersController());
  }

  public UsersModule getUsersModule() {
    return this.usersModule;
  }

  public UsersModuleUI getUsersModuleUI() {
    return this.usersModuleUI;
  }
}

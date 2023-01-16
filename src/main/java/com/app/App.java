package com.app;

import com.app.apps.AuthApp;
import com.app.apps.UsersApp;
import com.app.backend.database.Database;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.components.auth.AuthMenu;
import com.app.frontend.components.menu.Menu;

public class App {

  public static void main(String[] args) {
    UsersApp usersApp;
    AuthApp authApp;

    AuthMenu authMenu;
    Menu menu;

    UserEntity user;

    // Databse Connection
    Database.connect();

    // Users App Instance
    usersApp = new UsersApp(Database.getInstance());

    // Auth App Instance
    authApp = new AuthApp(Database.getInstance(), usersApp.getUsersModule());

    // Menu Instance
    menu = new Menu(usersApp.getUsersModuleUI(), authApp.getAuthModuleUI());
    menu.show();
  }
}

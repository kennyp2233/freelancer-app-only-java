package com.app.frontend.components.users;

import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.Input;
import com.app.frontend.modules.UsersModuleUI;

public class UsersMenu {
  private UserEntity user;
  private UsersComponentUI usersComponentUI;
  private Input input;

  public UsersMenu(UserEntity user, UsersModuleUI usersModuleUI) {
    this.usersComponentUI = usersModuleUI.getUsersComponentUI();
    this.user = user;
    this.input = new Input();
  }

  public void show() {
    String output;
    int option;

    output = "User Menu\n";
    output += "Select an option:\n";
    output += "\t1. View Profile\n";
    output += "\t2. Update Profile\n";
    output += "\t3. Log out\n";

  }

  public void showProfile() {
    // this.usersComponentUI.showUsers();
  }

}

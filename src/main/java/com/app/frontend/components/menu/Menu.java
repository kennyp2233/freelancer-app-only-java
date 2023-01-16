package com.app.frontend.components.menu;

import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.Input;
import com.app.frontend.components.auth.AuthComponentUI;
import com.app.frontend.components.auth.AuthMenu;
import com.app.frontend.components.profile.ProfileMenu;
import com.app.frontend.components.users.UsersComponentUI;
import com.app.frontend.components.users.UsersMenu;
import com.app.frontend.modules.AuthModuleUI;
import com.app.frontend.modules.UsersModuleUI;

public class Menu {
  private ProfileMenu profileMenu;
  private AuthMenu authMenu;
  private UsersMenu usersMenu;
  private Input input;
  private UsersModuleUI usersModuleUI;

  public Menu(UsersModuleUI usersModuleUI, AuthModuleUI authModuleUI) {
    this.usersModuleUI = usersModuleUI;
    this.authMenu = new AuthMenu(usersModuleUI, authModuleUI);
    this.input = new Input();
  }

  public void show() {
    UserEntity user;
    String output;
    int option;

    user = this.authMenu.show();
    this.profileMenu = new ProfileMenu(user, usersModuleUI);

    output = "User Menu\n";
    output += "Select an option:\n";
    output += "\t1. User Menu\n";
    output += "\t2. Admin Menu\n";
    output += "\t3. Log out\n";

    do {
      System.out.println(output);
      option = this.input.readInt("Enter the option: ");

      switch (option) {
        case 1:
          System.out.println("\nUser Menu");
          this.profileMenu.show();
          break;
        case 2:
          System.out.println("\nAdmin Menu");
          this.usersMenu.show();
          break;
        case 3:
          System.out.println("Log out\n");
          user = this.authMenu.show();
          break;
        case 4:
          System.out.println("Exit\n");
          break;
        case -1:
          System.out.println("Invalid option");
          break;
      }
    } while (option != 4);
  }
}

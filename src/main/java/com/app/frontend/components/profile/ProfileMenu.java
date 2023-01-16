package com.app.frontend.components.profile;

import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.Input;
import com.app.frontend.modules.UsersModuleUI;

public class ProfileMenu {
  private UserEntity user;
  private ProfileComponentUI profileComponentUI;
  private Input input;

  public ProfileMenu(UserEntity user, UsersModuleUI usersModuleUI) {
    usersModuleUI.initUsersComponentUI(user);
    this.profileComponentUI = usersModuleUI.getProfileComponentUI();
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
    output += "\t3. Delete Account\n";
    output += "\t4. Log out\n";

    do {
      System.out.println(output);
      option = this.input.readInt("Enter the option: ");

      switch (option) {
        case 1:
          System.out.println("\nView Profile");
          this.profileComponentUI.show();
          break;
        case 2:
          System.out.println("\nUpdate Profile");
          this.profileComponentUI.update();
          break;
        case 3:
          System.out.println("\nDelete Account");
          this.profileComponentUI.delete();
          break;
        case 4:
          System.out.println("Log out\n");
          break;
        case -1:
          System.out.println("Invalid option");
          break;
      }
    } while (option != 4);
  }
}

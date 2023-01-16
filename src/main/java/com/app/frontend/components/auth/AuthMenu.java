package com.app.frontend.components.auth;

import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.Input;
import com.app.frontend.modules.AuthModuleUI;
import com.app.frontend.modules.UsersModuleUI;

public class AuthMenu {
  private AuthComponentUI authComponentUI;
  private Input input;

  public AuthMenu(UsersModuleUI usersModuleUI, AuthModuleUI authModuleUI) {
    this.authComponentUI = authModuleUI.getAuthComponentUI();
    this.input = new Input();
  }

  public UserEntity show() {
    UserEntity userEntity;
    String output;
    int option;

    output = "Netnow App\n";
    output += "Select an option:\n";
    output += "\t1. Login\n";
    output += "\t2. Sign Up\n";
    output += "\t3. Exit\n";

    userEntity = null;
    do {
      System.out.println(output);
      option = this.input.readInt("Enter the option: ");

      switch (option) {
        case 1:
          System.out.println("\nLogin");
          userEntity = this.authComponentUI.login();
          break;
        case 2:
          System.out.println("\nSign Up");
          userEntity = this.authComponentUI.register();
          break;
        case 3:
          System.out.println("Exit\n");
          break;
        case -1:
          System.out.println("Invalid option");
          break;
      }
    } while (option != 3 && userEntity == null);

    return userEntity;
  }
}

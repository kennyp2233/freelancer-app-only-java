package com.app.frontend.components.profile;

import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.FormatResponse;
import com.app.frontend.common.input.UserInput;
import com.app.frontend.services.UsersServiceUI;

public class ProfileComponentUI {
  private UsersServiceUI usersServicesUI;
  private UserEntity user;
  private UserInput userInput;

  // public UsersComponentUI(UserEntity admin, UsersController usersController) {
  // this.usersServicesUI = new UsersServicesUI(usersController);
  // this.userInput = new UserInput();
  // this.userOutput = new UserOutput();
  // this.admin = admin;
  // }

  public ProfileComponentUI(UserEntity user, UsersServiceUI usersServicesUI) {
    this.usersServicesUI = usersServicesUI;
    this.user = user;
    this.userInput = new UserInput();
  }

  public void show() {
    Response response;

    response = this.usersServicesUI.getUserById(this.user.getId());

    System.out.println(FormatResponse.format(response));
  }

  public void update() {
    Response response;
    UserDTO updateUserDTO;

    System.out.println("Update your profile, leave the fields blank if you don't want to update them");
    updateUserDTO = this.userInput.readUserDTO();

    response = this.usersServicesUI.update(this.user.getId(), updateUserDTO);

    System.out.println(FormatResponse.format(response));
  }

  public void delete() {
    Response response;

    String option = this.userInput.readString("Are you sure you want to delete your profile? (y/n): ");

    if (option.equals("y")) {
      response = this.usersServicesUI.delete(this.user.getId());
    } else {
      response = new ErrorResponse("User not deleted");
    }

    System.out.println(FormatResponse.format(response));
  }
}

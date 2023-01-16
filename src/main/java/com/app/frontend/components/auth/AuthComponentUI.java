package com.app.frontend.components.auth;

import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.common.responses.Response;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.AuthInput;
import com.app.frontend.common.input.FormatResponse;
import com.app.frontend.common.input.UserInput;
import com.app.frontend.services.AuthServiceUI;

public class AuthComponentUI {
  private AuthServiceUI authServicesUI;
  private UserInput userInput;
  private AuthInput authInput;

  public AuthComponentUI(AuthServiceUI authServicesUI) {
    this.authServicesUI = authServicesUI;
    this.userInput = new UserInput();
    this.authInput = new AuthInput();
  }

  public UserEntity register() {
    Response response;
    AuthDTO createAuthDTO;
    UserDTO createUserDTO;

    // Create auth dto from user input
    System.out.println("Enter the user credentials (Password min length 8, max length 20):");
    createAuthDTO = this.authInput.readAuthDTO();

    System.out.println("\nUser information:");
    // Create user dto from user input
    createUserDTO = userInput.readUserDTO();

    // Response from auth service UI
    response = this.authServicesUI.register(createAuthDTO, createUserDTO);

    System.out.println(FormatResponse.format(response));

    return (UserEntity) response.getData();
  }

  public UserEntity login() {
    Response response;
    String email;
    String password;

    email = this.authInput.readString("Enter the email:");
    password = this.authInput.readString("Enter the password:");

    response = this.authServicesUI.login(email, password);

    System.out.println(FormatResponse.format(response));

    return (UserEntity) response.getData();
  }
}

package com.app.frontend.common.input;

import com.app.backend.users.dtos.UserDTO;

public class UserInput extends Input {
  public UserInput() {
    super();
  }

  public UserDTO readUserDTO() {
    UserDTO userDTO;
    String name;
    String email;

    name = this.readString("Enter the name: ");
    if (name.equals("")) {
      name = null;
    }

    email = this.readString("Enter the email: ");
    if (email.equals("")) {
      email = null;
    }

    userDTO = new UserDTO(name, email);

    return userDTO;
  }
}

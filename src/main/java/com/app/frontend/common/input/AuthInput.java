package com.app.frontend.common.input;

import com.app.backend.auth.dtos.AuthDTO;

public class AuthInput extends Input {
  public AuthInput() {
    super();
  }

  public AuthDTO readAuthDTO() {
    AuthDTO authDTO;
    String email;
    String password;

    email = this.readString("Enter the email: ");
    password = this.readString("Enter the password: ");

    authDTO = new AuthDTO(email, password);

    return authDTO;
  }
}
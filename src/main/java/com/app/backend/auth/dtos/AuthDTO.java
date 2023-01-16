package com.app.backend.auth.dtos;

import com.app.common.validators.ClassValidator;

public class AuthDTO {
  private String email;
  private String password;

  public AuthDTO(String email, String password) {
    this.email = email;
    this.password = password;
  }

  public AuthDTO(AuthDTO user) {
    this.email = user.getEmail();
    this.password = user.getPassword();
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }

  public boolean isCreateDTO() {
    if (!ClassValidator.isEmail(this.email)) {
      return false;
    }

    if (!ClassValidator.isPassword(this.password)) {
      return false;
    }

    return true;
  }

  public boolean isUpdateDTO() {
    if (this.email != null && !ClassValidator.isEmail(this.email)) {
      return false;
    }

    if (this.password != null && !ClassValidator.isPassword(this.password)) {
      return false;
    }

    return true;
  }
}

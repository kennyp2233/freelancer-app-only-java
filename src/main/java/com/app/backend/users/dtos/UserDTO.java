package com.app.backend.users.dtos;

import com.app.common.validators.ClassValidator;

public class UserDTO {
  private String name;
  private String email;

  public UserDTO(String name, String email) {
    this.name = name;
    this.email = email;
  }

  public UserDTO(UserDTO user) {
    this.name = user.getName();
    this.email = user.getEmail();
  }

  public String getName() {
    return this.name;
  }

  public String getEmail() {
    return this.email;
  }

  public boolean isCreateUserDTO() {
    if (!ClassValidator.isString(this.name)) {
      return false;
    }

    if (!ClassValidator.isEmail(this.email)) {
      return false;
    }

    return true;
  }

  public boolean isUpdateUserDTO() {
    if (this.name != null && !ClassValidator.isString(this.name)) {
      return false;
    }

    if (this.email != null && !ClassValidator.isEmail(this.email)) {
      return false;
    }

    return true;
  }

}

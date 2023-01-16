package com.app.backend.auth.entities;

import com.app.backend.auth.dtos.AuthDTO;

public class AuthEntity {
  private String id;
  private String email;
  private String password;

  public AuthEntity(String id, String email, String password) {
    this.id = id;
    this.email = email;
    this.password = password;
  }

  public AuthEntity(AuthEntity authData) {
    this.id = authData.getId();
    this.email = authData.getEmail();
    this.password = authData.getPassword();
  }

  public AuthEntity(String id, AuthDTO createAuthDTO) {
    this.id = id;
    this.email = createAuthDTO.getEmail();
    this.password = createAuthDTO.getPassword();
  }

  public String getId() {
    return id;
  }

  public String getEmail() {
    return email;
  }

  public String getPassword() {
    return password;
  }
}

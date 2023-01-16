package com.app.backend.users.entities;

import com.app.backend.users.dtos.UserDTO;

public class UserEntity {
  private String id;
  private String name;
  private String email;

  public UserEntity(String id, String name, String email) {
    this.id = id;
    this.name = name;
    this.email = email;
  }

  public UserEntity(UserEntity user) {
    this.id = user.getId();
    this.name = user.getName();
    this.email = user.getEmail();
  }

  public UserEntity(String id, UserDTO user) {
    this.id = id;
    this.name = user.getName();
    this.email = user.getEmail();
  }

  public String getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getEmail() {
    return email;
  }

  @Override
  public String toString() {
    String data;

    data = "{\n";
    data += "\tid: " + id + ", \n";
    data += "\tname: " + name + ", \n";
    data += "\temail: " + email + ", \n";
    data += "}";

    return data;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result = prime * result + ((name == null) ? 0 : name.hashCode());
    result = prime * result + ((email == null) ? 0 : email.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (obj == null)
      return false;
    if (getClass() != obj.getClass())
      return false;
    UserEntity other = (UserEntity) obj;
    if (id == null) {
      if (other.id != null)
        return false;
    } else if (!id.equals(other.id))
      return false;
    if (name == null) {
      if (other.name != null)
        return false;
    } else if (!name.equals(other.name))
      return false;
    if (email == null) {
      if (other.email != null)
        return false;
    } else if (!email.equals(other.email))
      return false;

    return true;
  }

}

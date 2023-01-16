package com.app.backend.common.errors;

public class EmailAlreadyExistsException extends Exception {
  public EmailAlreadyExistsException() {
    super("User with this email already exists");
  }
}

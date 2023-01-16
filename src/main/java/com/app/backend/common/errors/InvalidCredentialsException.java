package com.app.backend.common.errors;

public class InvalidCredentialsException extends Exception {
  public InvalidCredentialsException() {
    super("Invalid Credentials");
  }
}

package com.app.backend.common.errors;

public class NotFoundException extends Exception {
  public NotFoundException() {
    super("Not Found");
  }
}

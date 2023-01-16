package com.app.backend.common.errors;

public class BadRequestException extends Exception {
  public BadRequestException() {
    super("Bad Request");
  }
}

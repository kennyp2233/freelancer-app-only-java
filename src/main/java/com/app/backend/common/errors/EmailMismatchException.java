package com.app.backend.common.errors;

public class EmailMismatchException extends Exception {
  public EmailMismatchException() {
    super("Emails mismatch");
  }
}

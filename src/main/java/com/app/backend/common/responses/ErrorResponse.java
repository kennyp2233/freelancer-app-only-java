package com.app.backend.common.responses;

public class ErrorResponse extends Response {

  public ErrorResponse(String message) {
    super(true, message, null);
  }

  @Override
  public String toString() {
    String data;

    data = "{\n";
    data += "\terror: " + this.error + ", \n";
    data += "\tmessage: " + this.message + ", \n";
    data += "}";

    return data;
  }
}

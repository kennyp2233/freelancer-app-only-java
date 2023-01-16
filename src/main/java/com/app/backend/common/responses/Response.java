package com.app.backend.common.responses;

public class Response {
  protected boolean error;
  protected String message;
  protected Object data;

  public Response(boolean error, String message, Object data) {
    this.error = error;
    this.message = message;
    this.data = data;
  }

  public boolean getError() {
    return error;
  }

  public String getMessage() {
    return message;
  }

  public Object getData() {
    return data;
  }

  @Override
  public String toString() {
    String response;

    response = "{\n";
    response += "\tid: " + error + ", \n";
    response += "\tname: " + message + ", \n";
    response += "\temail: " + data + ", \n";
    response += "}";

    return response;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + (error ? 1231 : 1237);
    result = prime * result + ((message == null) ? 0 : message.hashCode());
    result = prime * result + ((data == null) ? 0 : data.hashCode());
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
    Response other = (Response) obj;
    if (error != other.error)
      return false;
    if (message == null) {
      if (other.message != null)
        return false;
    } else if (!message.equals(other.message))
      return false;
    if (data == null) {
      if (other.data != null)
        return false;
    } else if (!data.equals(other.data))
      return false;
    return true;
  }

}

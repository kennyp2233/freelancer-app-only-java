package com.app.common.validators;

import java.util.UUID;

public class ClassValidator {
  public static boolean isString(String string) {
    return string != null && !string.isBlank() && string.length() > 0;
  }

  public static boolean isString(String string, int minLength) {
    boolean isValid;

    isValid = isString(string) && string.length() >= minLength;

    return isValid;
  }

  public static boolean isString(String string, int minLength, int maxLength) {
    boolean isValid;

    isValid = isString(string, minLength) && string.length() <= maxLength;

    return isValid;
  }

  public static boolean isInteger(String integer) {
    try {
      Integer.parseInt(integer);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }

  public static boolean isEmail(String email) {
    String regex;
    boolean isValid;

    regex = "^[\\w!#$%&amp;'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&amp;'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";

    isValid = email != null && email.matches(regex);

    return isValid;
  }

  public static boolean isPassword(String password) {
    boolean isValid;

    isValid = isString(password, 8, 20);

    return isValid;
  }

  public static boolean isId(String id) {
    try {
      UUID.fromString(id);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    }
  }
}

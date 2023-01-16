package com.app.backend.common.utils;

import java.util.UUID;

public class Generator {
  public static String generateId() {
    UUID id = UUID.randomUUID();

    return id.toString();
  }
}

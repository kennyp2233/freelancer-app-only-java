package com.app.common.Mocks;

import java.lang.reflect.Field;

public class SingletonMock {
  public static void setMock(Object mock) {
    try {
      Field instance = Object.class.getDeclaredField("instance");
      instance.setAccessible(true);
      instance.set(instance, mock);
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
  }
}

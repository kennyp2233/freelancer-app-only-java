package com.app.backend.common.models;

import java.util.ArrayList;

public interface IRepository<T, U> {
  T insert(T item);

  ArrayList<T> getAll();

  T getById(String id);

  T update(String id, U item);

  T delete(String id);
}

package com.app.backend.common.models;

import java.util.ArrayList;

import com.app.backend.database.Database;

public abstract class Repository<T, U> implements IRepository<T, U> {
  protected Database database;
  protected ArrayList<T> collection;

  protected Repository(Database database) {
    this.database = database;
  };
}

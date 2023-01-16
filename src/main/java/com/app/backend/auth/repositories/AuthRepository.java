package com.app.backend.auth.repositories;

import java.util.ArrayList;

import com.app.backend.auth.dtos.AuthDTO;
import com.app.backend.auth.entities.AuthEntity;
import com.app.backend.common.models.Repository;
import com.app.backend.database.Database;

public class AuthRepository extends Repository<AuthEntity, AuthDTO> {
  private static AuthRepository instance = null;
  private ArrayList<AuthEntity> collection = new ArrayList<AuthEntity>();

  private AuthRepository(Database database) {
    super(database);
    this.collection = database.getAuthUsers();
  }

  public static void initInstance(Database database) {
    if (instance == null) {
      instance = new AuthRepository(database);
    }
  }

  public static AuthRepository getInstance() {
    if (instance == null) {
      throw new RuntimeException("Auth Repository not initialized");
    }
    return instance;
  }

  public AuthEntity insert(AuthEntity userAuth) {
    if (this.getByEmail(userAuth.getEmail()) != null) {
      return null;
    }

    this.collection.add(userAuth);

    return userAuth;
  }

  public AuthEntity getByEmail(String email) {
    for (AuthEntity user : this.collection) {
      if (user.getEmail().equals(email)) {
        return user;
      }
    }

    return null;
  }

  public AuthEntity update(String email, AuthEntity userData) {
    AuthEntity currentUser;
    AuthEntity updatedUser;

    currentUser = this.getByEmail(email);

    if (currentUser == null) {
      return null;
    }

    int index = this.collection.indexOf(currentUser);
    updatedUser = new AuthEntity(userData);
    this.collection.set(index, userData);

    return updatedUser;
  }

  @Override
  public ArrayList<AuthEntity> getAll() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthEntity getById(String id) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthEntity update(String id, AuthDTO item) {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public AuthEntity delete(String id) {
    // TODO Auto-generated method stub
    return null;
  }
}

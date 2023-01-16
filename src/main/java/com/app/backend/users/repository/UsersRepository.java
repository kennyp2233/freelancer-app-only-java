package com.app.backend.users.repository;

import java.util.ArrayList;

import com.app.backend.common.models.Repository;
import com.app.backend.database.Database;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;

public class UsersRepository extends Repository<UserEntity, UserDTO> {
  private static UsersRepository instance = null;
  private ArrayList<UserEntity> collection = new ArrayList<UserEntity>();

  private UsersRepository(Database database) {
    super(database);
    this.collection = database.getUsers();
  }

  public static void initInstance(Database database) {
    if (instance == null) {
      instance = new UsersRepository(database);
    }
  }

  public static UsersRepository getInstance() {
    if (instance == null) {
      throw new RuntimeException("Users Repository not initialized");
    }
    return instance;
  }

  public UserEntity insert(UserEntity user) {
    this.collection.add(user);

    return user;
  }

  public ArrayList<UserEntity> getAll() {
    return this.collection;
  }

  public UserEntity getById(String id) {
    for (UserEntity user : this.collection) {
      if (user.getId().equals(id)) {
        return user;
      }
    }

    return null;
  }

  public UserEntity getByEmail(String email) {
    for (UserEntity user : this.collection) {
      if (user.getEmail().equals(email)) {
        return user;
      }
    }

    return null;
  }

  public UserEntity update(String id, UserDTO userDTO) {
    UserEntity currentUser;
    UserEntity updatedUser;

    currentUser = this.getById(id);

    if (currentUser == null) {
      return null;
    }

    int index = this.collection.indexOf(currentUser);
    updatedUser = getNewUserDataToUpdate(id, userDTO);
    this.collection.set(index, updatedUser);

    return updatedUser;
  }

  public UserEntity delete(String id) {
    UserEntity user = this.getById(id);

    if (user == null) {
      return null;
    }

    this.collection.remove(user);
    return user;
  }

  public boolean deleteAll() {
    this.collection.clear();

    return true;
  }

  // Parse user entity to get only the data that can be updated and delete nulls
  private UserEntity getNewUserDataToUpdate(String id, UserDTO user) {
    UserEntity newUser;
    UserEntity currentUser;

    currentUser = this.getById(id);
    newUser = new UserEntity(
        id,
        user.getName() != null ? user.getName() : currentUser.getName(),
        user.getEmail() != null ? user.getEmail() : currentUser.getEmail());

    return newUser;
  }
}

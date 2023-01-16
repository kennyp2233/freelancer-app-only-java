package com.app.backend.database;

import java.util.ArrayList;

import com.app.backend.auth.entities.AuthEntity;
import com.app.backend.posts.entities.PostEntity;
import com.app.backend.users.entities.UserEntity;

public class Database {
  private static Database instance = null;
  private ArrayList<UserEntity> users = new ArrayList<UserEntity>();
  private ArrayList<PostEntity> posts = new ArrayList<PostEntity>();
  private ArrayList<AuthEntity> authUsers = new ArrayList<AuthEntity>();

  private Database() {
    this.users = new ArrayList<UserEntity>();
    this.posts = new ArrayList<PostEntity>();
    this.authUsers = new ArrayList<AuthEntity>();
  }

  public static void connect() {
    if (instance == null) {
      instance = new Database();
    }
  }

  public static Database getInstance() {
    if (instance == null) {
      throw new RuntimeException("Database not initialized");
    }
    return instance;
  }

  public ArrayList<UserEntity> getUsers() {
    return this.users;
  }

  public ArrayList<PostEntity> getPosts() {
    return this.posts;
  }

  public ArrayList<AuthEntity> getAuthUsers() {
    return this.authUsers;
  }
}

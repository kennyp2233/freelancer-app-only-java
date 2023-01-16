package com.app.backend.posts;

import com.app.backend.database.Database;
import com.app.backend.posts.controller.PostsController;
import com.app.backend.posts.repositories.PostsRepository;
import com.app.backend.posts.services.PostsService;

public class PostsModule {
  private PostsController usersController;
  private PostsService usersService;
  private PostsRepository postsRepository;

  private static PostsModule instance = null;

  private PostsModule(Database database) {
    PostsRepository.initInstance(database);
    this.postsRepository = PostsRepository.getInstance();

    PostsService.initInstance(this.postsRepository);
    this.usersService = PostsService.getInstance();

    PostsController.initInstance(this.usersService);
    this.usersController = PostsController.getInstance();
  }

  public static void initInstance(Database database) {
    instance = new PostsModule(database);
  }

  public static PostsModule getInstance() {
    if (instance == null) {
      throw new RuntimeException("Posts Module not initialized");
    }
    return instance;
  }

  public PostsService getPostsService() {
    return usersService;
  }

  public PostsController getPostsController() {
    return usersController;
  }

}

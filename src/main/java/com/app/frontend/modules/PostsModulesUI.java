package com.app.frontend.modules;

import com.app.backend.posts.controller.PostsController;
import com.app.frontend.components.posts.PostsComponentUI;
import com.app.frontend.services.PostsServiceUI;

public class PostsModulesUI {
  private PostsComponentUI postsComponentUI;
  private PostsServiceUI postsServiceUI;

  public PostsModulesUI(PostsController postsController) {
    this.postsServiceUI = new PostsServiceUI(postsController);
  }

  public void initPostsComponentUI(UserEntity user) {
    this.postsComponentUI = new PostsComponentUI(user, this.postsServiceUI);
  }

}

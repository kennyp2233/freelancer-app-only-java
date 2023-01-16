package com.app.frontend.services;

import com.app.backend.common.responses.Response;
import com.app.backend.posts.controller.PostsController;
import com.app.backend.posts.dtos.PostDTO;

public class PostsServiceUI {
  private PostsController postsController;

  public PostsServiceUI(PostsController postsController) {
    this.postsController = postsController;
  }

  public Response create(PostDTO createPostDTO) {
    Response response;
    response = this.postsController.create(createPostDTO);

    return response;
  }

  public Response getAll() {
    Response response;
    response = this.postsController.getAll();

    return response;
  }

  public Response getPostById(String postId) {
    Response response;
    response = this.postsController.getById(postId);

    return response;
  }

  public Response update(String postId, PostDTO updatePostDTO) {
    Response response;
    response = this.postsController.update(postId, updatePostDTO);

    return response;
  }

  public Response delete(String postId) {
    Response response;

    response = this.postsController.delete(postId);

    return response;
  }
}

package com.app.backend.posts.controller;

import java.util.ArrayList;

import com.app.backend.common.responses.ErrorResponse;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SuccessResponse;
import com.app.backend.posts.dtos.PostDTO;
import com.app.backend.posts.entities.PostEntity;
import com.app.backend.posts.services.PostsService;

public class PostsController {
  private static PostsController instance = null;
  private PostsService service;

  private PostsController(PostsService service) {
    this.service = service;
  }

  public static void initInstance(PostsService service) {
    if (instance == null) {
      instance = new PostsController(service);
    }
  }

  public static PostsController getInstance() {
    if (instance == null) {
      throw new RuntimeException("Posts Controller not initialized");
    }
    return instance;
  }

  public Response create(PostDTO postDto) {
    PostEntity post;
    Response response;

    try {
      post = this.service.create(postDto);

      response = new SuccessResponse("Post created", post);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response getAll() {
    ArrayList<PostEntity> posts;
    Response response;

    try {
      posts = this.service.getAll();
      response = new SuccessResponse("OK", posts);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response getById(String id) {
    PostEntity post;
    Response response;

    try {
      post = this.service.getById(id);
      response = new SuccessResponse("Post found", post);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response update(String id, PostDTO postDto) {
    PostEntity post;
    Response response;

    try {
      post = this.service.update(id, postDto);
      response = new SuccessResponse("Post updated", post);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

  public Response delete(String id) {
    PostEntity post;
    Response response;

    try {
      post = this.service.delete(id);
      response = new SuccessResponse("Post deleted", post);
    } catch (Exception e) {
      response = new ErrorResponse(e.getMessage());
    }

    return response;
  }

}

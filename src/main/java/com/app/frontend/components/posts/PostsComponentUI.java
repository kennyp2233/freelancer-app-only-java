package com.app.frontend.components.posts;

import com.app.backend.common.responses.Response;
import com.app.backend.posts.dtos.PostDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.frontend.common.input.PostsInput;
import com.app.frontend.services.PostsServiceUI;

public class PostsComponentUI {
  private PostsServiceUI postsServiceUI;
  private PostsInput postsInput;
  private UserEntity user;

  public PostsComponentUI(UserEntity user, PostsServiceUI postsServiceUI) {
    this.postsServiceUI = postsServiceUI;
    this.postsInput = new PostsInput();
    this.user = user;
  }

  public void create() {
    Response response;
    PostDTO createPostDTO;

    createPostDTO = this.postsInput.readPostDTO(user.getId());

    response = this.postsServiceUI.create(createPostDTO);

    System.out.println(response);
  }

  public void getById() {
    Response response;
    String userId;

    userId = this.postsInput.readString("Enter the post id:");

    response = this.postsServiceUI.getPostById(userId);

    System.out.println(response);
  }

  public void getAll() {
    Response response;

    response = this.postsServiceUI.getAll();

    System.out.println(response);
  }

  public void update(String postId) {
    Response response;
    PostDTO updatePostDTO;

    updatePostDTO = this.postsInput.readPostDTO(this.user.getId());

    response = this.postsServiceUI.update(postId, updatePostDTO);

    System.out.println(response);
  }

  public void delete(String postId) {
    Response response;

    response = this.postsServiceUI.delete(postId);

    System.out.println(response);
  }
}

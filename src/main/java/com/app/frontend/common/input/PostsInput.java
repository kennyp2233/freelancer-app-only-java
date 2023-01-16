package com.app.frontend.common.input;

import com.app.backend.posts.dtos.PostDTO;

public class PostsInput extends Input {
  public PostDTO readPostDTO(String authorId) {
    PostDTO postDTO;
    String title;
    String content;

    title = this.readString("\nEnter the title:");
    content = this.readString("\nEnter the email:");

    postDTO = new PostDTO(title, content, authorId);

    return postDTO;
  }
}

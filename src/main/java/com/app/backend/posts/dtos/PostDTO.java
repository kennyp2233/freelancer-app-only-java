package com.app.backend.posts.dtos;

import com.app.common.validators.ClassValidator;

public class PostDTO {
  private String id;
  private String title;
  private String content;
  private String authorId;

  public PostDTO(String id, String title, String content, String authorId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }

  public PostDTO(String title, String content, String authorId) {
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }

  public boolean isCreatePostDTO() {
    if (!ClassValidator.isId(id)) {
      return false;
    }

    if (!ClassValidator.isString(this.title, 10, 50)) {
      return false;
    }

    if (!ClassValidator.isString(this.content, 50, 500)) {
      return false;
    }

    if (!ClassValidator.isId(authorId)) {
      return false;
    }

    return true;
  }

  public boolean isUpdatePostDTO() {
    if (this.title != null && !ClassValidator.isString(this.title, 10, 50)) {
      return false;
    }

    if (this.content != null && !ClassValidator.isString(this.content, 50, 500)) {
      return false;
    }

    if (this.authorId != null && !ClassValidator.isId(authorId)) {
      return false;
    }

    return true;
  }

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getContent() {
    return content;
  }

  public String getAuthorId() {
    return authorId;
  }

}

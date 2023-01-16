package com.app.backend.posts.entities;

public class PostEntity {
  private String id;
  private String title;
  private String content;
  private String authorId;

  public PostEntity(String id, String title, String content, String authorId) {
    this.id = id;
    this.title = title;
    this.content = content;
    this.authorId = authorId;
  }

  public PostEntity(PostEntity userData) {
    this.id = userData.getId();
    this.title = userData.getTitle();
    this.content = userData.getContent();
    this.authorId = userData.getAuthorId();
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

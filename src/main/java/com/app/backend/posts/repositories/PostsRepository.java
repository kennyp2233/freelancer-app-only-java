package com.app.backend.posts.repositories;

import java.util.ArrayList;

import com.app.backend.common.models.Repository;
import com.app.backend.database.Database;
import com.app.backend.posts.dtos.PostDTO;
import com.app.backend.posts.entities.PostEntity;

public class PostsRepository extends Repository<PostEntity, PostDTO> {
  private static PostsRepository instance = null;
  private ArrayList<PostEntity> collection = new ArrayList<PostEntity>();

  private PostsRepository(Database database) {
    super(database);
    this.collection = database.getPosts();
  }

  public static void initInstance(Database database) {
    if (instance == null) {
      instance = new PostsRepository(database);
    }
  }

  public static PostsRepository getInstance() {
    if (instance == null) {
      throw new RuntimeException("Posts Repository not initialized");
    }
    return instance;
  }

  public PostEntity insert(PostEntity post) {
    this.collection.add(post);

    return post;
  }

  public ArrayList<PostEntity> getAll() {
    return this.collection;
  }

  public PostEntity getById(String id) {
    for (PostEntity user : this.collection) {
      if (user.getId().equals(id)) {
        return user;
      }
    }

    return null;
  }

  public PostEntity update(String id, PostDTO postDTO) {
    PostEntity currentPost;
    PostEntity updatedPost;

    currentPost = this.getById(id);
    if (currentPost == null) {
      return null;
    }

    int index = this.collection.indexOf(currentPost);
    updatedPost = getNewPostDataToUpdate(id, postDTO);
    this.collection.set(index, updatedPost);

    return updatedPost;
  }

  public PostEntity delete(String id) {
    PostEntity user = this.getById(id);

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

  private PostEntity getNewPostDataToUpdate(String id, PostDTO post) {
    PostEntity newPost;
    PostEntity currentPost;

    currentPost = this.getById(id);
    newPost = new PostEntity(
        id,
        post.getTitle() != null ? post.getTitle() : currentPost.getTitle(),
        post.getContent() != null ? post.getContent() : currentPost.getContent(),
        post.getAuthorId() != null ? post.getAuthorId() : currentPost.getAuthorId());

    return newPost;
  }
}

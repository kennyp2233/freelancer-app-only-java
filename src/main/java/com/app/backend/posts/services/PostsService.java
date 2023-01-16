package com.app.backend.posts.services;

import java.util.ArrayList;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.utils.Generator;
import com.app.backend.posts.dtos.PostDTO;
import com.app.backend.posts.entities.PostEntity;
import com.app.backend.posts.repositories.PostsRepository;

public class PostsService {
  private PostsRepository repository;
  private static PostsService instance = null;

  private PostsService(PostsRepository repository) {
    this.repository = repository;
  }

  public static void initInstance(PostsRepository repository) {
    if (instance == null) {
      instance = new PostsService(repository);
    }
  }

  public static PostsService getInstance() {
    if (instance == null) {
      throw new RuntimeException("Posts Service not initialized");
    }
    return instance;
  }

  public PostEntity create(PostDTO postDto) throws BadRequestException {
    String id;
    PostEntity newUser;

    if (postDto.isCreatePostDTO()) {
      throw new BadRequestException();
    }

    id = Generator.generateId();
    newUser = new PostEntity(id, postDto.getTitle(), postDto.getContent(), postDto.getAuthorId());
    this.repository.insert(newUser);

    return newUser;
  }

  public ArrayList<PostEntity> getAll() {
    return this.repository.getAll();
  }

  public PostEntity getById(String id) throws NotFoundException {
    PostEntity post;

    post = this.repository.getById(id);

    if (post == null) {
      throw new NotFoundException();
    }

    return post;
  }

  public PostEntity update(String id, PostDTO postDTO) throws NotFoundException, BadRequestException {
    PostEntity postUpdated;

    if (postDTO.isUpdatePostDTO()) {
      throw new BadRequestException();
    }

    // If ID not found, throws NotFoundException
    this.getById(id);

    postUpdated = this.repository.update(id, postDTO);

    return postUpdated;
  }

  public PostEntity delete(String id) throws NotFoundException {
    PostEntity postDeleted;

    // If id not found, throws NotFoundException
    this.getById(id);

    postDeleted = this.repository.delete(id);

    return postDeleted;
  }
}

package com.app.backend.users.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.common.responses.Response;
import com.app.backend.common.responses.SuccessResponse;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.services.UsersService;

public class UsersControllerTest {
  // private UsersService usersService;
  // private UsersController usersController;

  // @Before
  // public void setUp() {
  // this.usersService = mock(UsersService.class);
  // setMock(usersService);
  // UsersController.initInstance(usersService);
  // this.usersController = UsersController.getInstance();
  // }

  // @After
  // public void tearDown() {
  // this.usersService = null;
  // this.usersController = null;
  // }

  // @Test
  // public void shouldCreateUser() throws BadRequestException {
  // UserDTO userDto;
  // UserEntity expectedUser;
  // Response response;
  // Response expectedResponse;

  // expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
  // "222222");
  // userDto = new UserDTO("Alex Padilla", "alex@mail.com", "222222");

  // Mockito.when(usersService.create(userDto)).thenReturn(expectedUser);

  // response = this.usersController.create(userDto);
  // expectedResponse = new SuccessResponse("User created", expectedUser);

  // assertEquals(response, expectedResponse);
  // }

  // @Test
  // public void shouldGetUserById() throws BadRequestException, NotFoundException
  // {
  // UserEntity expectedUser;
  // Response response;
  // Response expectedResponse;

  // expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
  // "222222");

  // Mockito.when(usersService.getById(expectedUser.getId())).thenReturn(expectedUser);

  // response = this.usersController.getById(expectedUser.getId());

  // expectedResponse = new SuccessResponse("User found", expectedUser);

  // assertEquals(response, expectedResponse);
  // }

  // @Test
  // public void shouldUpdateUser() throws BadRequestException, NotFoundException
  // {
  // UserDTO userDto;
  // UserEntity userToUpdate;
  // UserEntity expectedUser;
  // Response response;
  // Response expectedResponse;

  // userToUpdate = new UserEntity("999999", "Erick Erazo", "erick@mail.com",
  // "111111");
  // expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
  // "222222");
  // userDto = new UserDTO("Alex Padilla", "alex@mail.com", "222222");

  // Mockito.when(usersService.getById(userToUpdate.getId())).thenReturn(userToUpdate);
  // Mockito.when(usersService.update(userToUpdate.getId(),
  // userDto)).thenReturn(expectedUser);

  // response = this.usersController.update(expectedUser.getId(), userDto);
  // expectedResponse = new SuccessResponse("User updated", expectedUser);

  // assertEquals(response, expectedResponse);
  // }

  // @Test
  // public void shouldDeleteUser() throws NotFoundException, BadRequestException
  // {
  // UserEntity expectedUser;
  // Response response;
  // Response expectedResponse;

  // expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
  // "222222");

  // Mockito.when(usersService.getById(expectedUser.getId())).thenReturn(expectedUser);
  // Mockito.when(usersService.delete(expectedUser.getId())).thenReturn(expectedUser);

  // response = this.usersController.delete(expectedUser.getId());
  // expectedResponse = new SuccessResponse("User deleted", expectedUser);

  // assertEquals(response, expectedResponse);
  // }

  // @Test
  // public void shouldGetAllUsers() {
  // UserEntity user1;
  // UserEntity user2;
  // UserEntity user3;
  // ArrayList<UserEntity> expectedUsers;
  // Response response;
  // Response expectedResponse;

  // user1 = new UserEntity("999999", "Alex Padilla", "alex@mail.com", "222222");
  // user2 = new UserEntity("888888", "Kenny Pinchao", "kenny@mail.com",
  // "333333");
  // user3 = new UserEntity("777777", "Erick Erazo", "erick@mail.com", "444444");

  // expectedUsers = new ArrayList<UserEntity>();
  // expectedUsers.add(user1);
  // expectedUsers.add(user2);
  // expectedUsers.add(user3);

  // Mockito.when(usersService.getAll()).thenReturn(expectedUsers);

  // response = this.usersController.getAll();
  // expectedResponse = new SuccessResponse("OK", expectedUsers);

  // assertEquals(response, expectedResponse);
  // }

  // private void setMock(UsersService mock) {
  // try {
  // Field instance = UsersService.class.getDeclaredField("instance");
  // instance.setAccessible(true);
  // instance.set(instance, mock);
  // } catch (Exception e) {
  // throw new RuntimeException(e);
  // }
  // }
}

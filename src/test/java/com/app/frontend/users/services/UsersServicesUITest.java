// package com.app.frontend.users.services;

// import static org.junit.Assert.assertEquals;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.mock;

// import java.lang.reflect.Field;
// import java.util.ArrayList;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.mockito.Mockito;

// import com.app.backend.common.responses.ErrorResponse;
// import com.app.backend.common.responses.Response;
// import com.app.backend.common.responses.SuccessResponse;
// import com.app.backend.users.controllers.UsersController;
// import com.app.backend.users.dtos.UserDTO;
// import com.app.backend.users.entities.UserEntity;
// import com.app.backend.users.repository.UsersRepository;

// public class UsersServicesUITest {
// private UsersServicesUI usersServicesUI;
// private UsersController usersController;

// @Before
// public void setUp() {
// this.usersController = mock(UsersController.class);
// setMock(usersController);
// this.usersServicesUI = new UsersServicesUI(usersController);
// }

// @Test
// public void shouldCreateUser() {
// Response response;
// Response expectedResponse;
// UserEntity expectedUser;
// UserDTO userDTO;

// expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");
// userDTO = new UserDTO("Alex Padilla", "alex@mail.com", "222222");
// expectedResponse = new SuccessResponse("User created", expectedUser);

// Mockito.when(usersController.create(userDTO)).thenReturn(expectedResponse);

// response = this.usersServicesUI.create(userDTO);

// assertEquals(response, expectedResponse);
// }

// @Test
// public void shouldGetUserById() {
// Response response;
// Response expectedResponse;
// UserEntity expectedUser;

// expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");
// expectedResponse = new Response(false, "User found", expectedUser);

// Mockito.when(usersController.getById(expectedUser.getId())).thenReturn(expectedResponse);

// response = this.usersServicesUI.getUserById(expectedUser.getId());

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

// expectedResponse = new SuccessResponse("OK", expectedUsers);
// Mockito.when(usersServicesUI.getAll()).thenReturn(expectedResponse);

// response = this.usersController.getAll();

// assertEquals(response, expectedResponse);
// }

// @Test
// public void shouldUpdateAllUserData() {
// UserDTO userDto;
// UserEntity expectedUser;
// Response response;
// Response expectedResponse;

// expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");
// userDto = new UserDTO("Alex Padilla", "alex@mail.com", "222222");
// expectedResponse = new SuccessResponse("User updated", expectedUser);

// Mockito.when(usersController.update(expectedUser.getId(),
// userDto)).thenReturn(expectedResponse);

// response = this.usersServicesUI.update(expectedUser.getId(), userDto);

// assertEquals(response, expectedResponse);
// }

// @Test
// public void shouldDeleteUser() {
// UserEntity expectedUser;
// Response response;
// Response expectedResponse;

// expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");
// expectedResponse = new SuccessResponse("User deleted", expectedUser);

// Mockito.when(usersController.delete(expectedUser.getId())).thenReturn(expectedResponse);

// response = this.usersServicesUI.delete(expectedUser.getId());

// assertEquals(response, expectedResponse);
// }

// @Test
// public void shouldNotCreateUser() {
// Response response;
// Response expectedResponse;
// UserDTO userDTO;

// userDTO = new UserDTO("", "alex@mail.com", "");
// expectedResponse = new ErrorResponse("Bad request");

// Mockito.when(usersController.create(userDTO)).thenReturn(expectedResponse);

// response = this.usersServicesUI.create(userDTO);

// assertEquals(response, expectedResponse);
// }

// @Test
// public void shouldNotGetUserById() {
// Response response;
// Response expectedResponse;

// expectedResponse = new ErrorResponse("User not found");

// Mockito.when(usersController.getById(anyString())).thenReturn(expectedResponse);

// response = this.usersServicesUI.getUserById("randomId");

// assertEquals(response, expectedResponse);
// }

// private void setMock(UsersController mock) {
// try {
// Field instance = UsersController.class.getDeclaredField("instance");
// instance.setAccessible(true);
// instance.set(instance, mock);
// } catch (Exception e) {
// throw new RuntimeException(e);
// }
// }
// }

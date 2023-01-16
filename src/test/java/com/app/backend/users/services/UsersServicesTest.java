package com.app.backend.users.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;

import java.lang.reflect.Field;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.mockito.Mockito;

import com.app.backend.common.errors.BadRequestException;
import com.app.backend.common.errors.NotFoundException;
import com.app.backend.users.dtos.UserDTO;
import com.app.backend.users.entities.UserEntity;
import com.app.backend.users.repository.UsersRepository;

public class UsersServicesTest {
  // private UsersRepository usersRepository;
  // private UsersService usersService;

  // @Before
  // public void setUp() {
  // this.usersRepository = mock(UsersRepository.class);
  // setMock(this.usersRepository);
  // UsersService.initInstance(this.usersRepository);
  // this.usersService = UsersService.getInstance();
  // }

  // @After
  // public void tearDown() {
  // this.usersRepository = null;
  // this.usersService = null;
  // }

  // @Test
  // public void shouldCreateUser() throws BadRequestException {
  // UserDTO userDto;
  // UserEntity expectedUser;
  // UserEntity userCreated;

  // expectedUser = new UserEntity("999999", "Erick Erazo", "erick@mail.com",
  // "123456");
  // userDto = new UserDTO(expectedUser.getName(), expectedUser.getEmail(),
  // expectedUser.getPassword());

  // Mockito.when(usersRepository.insert(Mockito.any(UserEntity.class))).thenReturn(expectedUser);

  // userCreated = usersService.create(userDto);
  // expectedUser.setId(userCreated.getId());

  // assertEquals(userCreated, expectedUser);
  // }

  // @Test
  // public void shouldGetUserById() throws NotFoundException {
  // UserEntity expectedUser;
  // UserEntity userFinded;

  // expectedUser = new UserEntity("999999", "Erick Erazo", "erick@mail.com",
  // "123456");
  // Mockito.when(usersRepository.getById(expectedUser.getId())).thenReturn(expectedUser);

  // userFinded = this.usersService.getById(expectedUser.getId());

  // assertEquals(userFinded, expectedUser);
  // }

  // @Test
  // public void shouldUpdateUser() throws NotFoundException, BadRequestException
  // {
  // UserDTO dataToUpdate;
  // UserEntity user;
  // UserEntity userUpdated;
  // UserEntity expectedUser;

  // user = new UserEntity("999999", "Erick Erazo", "erick@mail.com", "123456");
  // expectedUser = new UserEntity("999999", "Kenny Pinchao", "kenny@mail.com",
  // "888888");

  // dataToUpdate = new UserDTO("Kenny Pinchao", "kenny@mail.com", "888888");

  // Mockito.when(usersRepository.getById(user.getId())).thenReturn(user);
  // Mockito.when(usersRepository.update(eq(expectedUser.getId()),
  // any(UserEntity.class)))
  // .thenAnswer(invocation -> invocation.getArgument(1, UserEntity.class));

  // userUpdated = this.usersService.update(user.getId(), dataToUpdate);

  // assertEquals(userUpdated, expectedUser);
  // }

  // @Test
  // public void shouldUpdateUserNameAndPassword() throws NotFoundException,
  // BadRequestException {
  // UserDTO dataToUpdate;
  // UserEntity user;
  // UserEntity userUpdated;
  // UserEntity expectedUser;

  // user = new UserEntity("999999", "Erick Erazo", "erick@mail.com", "123456");
  // expectedUser = new UserEntity("999999", "Kenny Pinchao", "erick@mail.com",
  // "888888");

  // dataToUpdate = new UserDTO("Kenny Pinchao", "", "888888");

  // Mockito.when(usersRepository.getById(user.getId())).thenReturn(user);
  // Mockito.when(usersRepository.update(eq(expectedUser.getId()),
  // any(UserEntity.class)))
  // .thenAnswer(invocation -> invocation.getArgument(1, UserEntity.class));

  // userUpdated = this.usersService.update(user.getId(), dataToUpdate);

  // assertEquals(userUpdated, expectedUser);
  // }

  // @Test
  // public void shouldDeleteUser() throws NotFoundException {
  // UserEntity expectedUser;
  // UserEntity userDeleted;

  // expectedUser = new UserEntity("999999", "Erick Erazo", "erick@mail.com",
  // "123456");

  // Mockito.when(usersRepository.getById(expectedUser.getId())).thenReturn(expectedUser);
  // Mockito.when(usersRepository.delete(expectedUser.getId())).thenReturn(expectedUser);

  // userDeleted = this.usersService.delete(expectedUser.getId());

  // assertEquals(userDeleted, expectedUser);
  // }

  // @Test(expected = BadRequestException.class)
  // public void shouldThrowsBadRequestExceptionOnCreate() throws
  // BadRequestException {
  // UserDTO userDto;

  // userDto = new UserDTO(null, "erick@mail.com", "123456");
  // usersService.create(userDto);
  // }

  // @Test(expected = NotFoundException.class)
  // public void shouldThrowsNotFoundExceptionOnGetById() throws NotFoundException
  // {
  // this.usersService.getById("inventedId");
  // }

  // @Test
  // public void shouldNotUpdate() throws NotFoundException, BadRequestException {
  // UserDTO dataToUpdate;
  // UserEntity user;
  // UserEntity userUpdated;
  // UserEntity expectedUser;

  // user = new UserEntity("999999", "Erick Erazo", "erick@mail.com", "123456");
  // expectedUser = new UserEntity("999999", "Erick Erazo", "erick@mail.com",
  // "123456");

  // dataToUpdate = new UserDTO("", "", "");

  // Mockito.when(usersRepository.getById(user.getId())).thenReturn(user);
  // Mockito.when(usersRepository.update(eq(expectedUser.getId()),
  // any(UserEntity.class)))
  // .thenAnswer(invocation -> invocation.getArgument(1, UserEntity.class));

  // userUpdated = this.usersService.update(user.getId(), dataToUpdate);

  // assertEquals(userUpdated, expectedUser);
  // }

  // @Test(expected = BadRequestException.class)
  // public void shouldNotUpdateBadEmail() throws NotFoundException,
  // BadRequestException {
  // UserDTO dataToUpdate;
  // UserEntity user;

  // user = new UserEntity("999999", "Erick Erazo", "erick@mail.com", "123456");

  // dataToUpdate = new UserDTO("Alex", "alex@.com", "123456");

  // Mockito.when(usersRepository.getById(user.getId())).thenReturn(user);
  // Mockito.when(usersRepository.update(eq(user.getId()), any(UserEntity.class)))
  // .thenAnswer(invocation -> invocation.getArgument(1, UserEntity.class));

  // this.usersService.update(user.getId(), dataToUpdate);
  // }

  // @Test(expected = NotFoundException.class)
  // public void shouldThrowsNotFoundExceptionOnDelete() throws NotFoundException
  // {
  // UserEntity expectedUser;

  // expectedUser = new UserEntity("999999", "Erick Erazo", "erick@mail.com",
  // "123456");

  // Mockito.when(usersRepository.getById("RandomId")).thenReturn(null);

  // this.usersService.delete(expectedUser.getId());
  // }

  // @After
  // public void resetSingleton() throws Exception {
  // Field instance = UsersRepository.class.getDeclaredField("instance");
  // instance.setAccessible(true);
  // instance.set(null, null);
  // }

  // private void setMock(UsersRepository usersRepository) {
  // try {
  // Field instance = UsersRepository.class.getDeclaredField("instance");
  // instance.setAccessible(true);
  // instance.set(instance, usersRepository);
  // } catch (Exception e) {
  // throw new RuntimeException(e);
  // }
  // }
}

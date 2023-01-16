// package com.app.backend.auth.services;

// import static org.junit.Assert.assertEquals;
// import static org.mockito.ArgumentMatchers.anyString;
// import static org.mockito.Mockito.mock;

// import java.lang.reflect.Field;

// import org.junit.Before;
// import org.junit.Test;
// import org.junit.jupiter.api.extension.ExtendWith;
// import org.mockito.Mock;
// import org.mockito.Mockito;
// import org.mockito.junit.jupiter.MockitoExtension;

// import com.app.backend.common.errors.InvalidCredentialsException;
// import com.app.backend.common.errors.NotFoundException;
// import com.app.backend.users.entities.UserEntity;
// import com.app.backend.users.services.UsersService;

// @ExtendWith(MockitoExtension.class)
// public class AuthServiceTest {

// private AuthService authService;
// private UsersService usersService;

// @Before
// public void setUp() {
// this.usersService = mock(UsersService.class);
// setMock(usersService);
// AuthService.initInstance(usersService);
// this.authService = AuthService.getInstance();
// }

// @Test
// public void shouldValidateUser() throws InvalidCredentialsException,
// NotFoundException {
// UserEntity user;
// UserEntity expectedUser;

// expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");

// Mockito.when(usersService.getById(expectedUser.getId())).thenReturn(expectedUser);

// user = this.authService.validateUser(expectedUser.getId(),
// expectedUser.getPassword());

// assertEquals(user, expectedUser);
// }

// @Test(expected = InvalidCredentialsException.class)
// public void shouldNotValidateUser() throws InvalidCredentialsException,
// NotFoundException {
// UserEntity user;
// UserEntity notExpectedUser;

// notExpectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");

// Mockito.when(usersService.getById(anyString())).thenReturn(notExpectedUser);

// user = this.authService.validateUser(notExpectedUser.getId(),
// "randomPassword");

// assertEquals(user, null);
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

// }

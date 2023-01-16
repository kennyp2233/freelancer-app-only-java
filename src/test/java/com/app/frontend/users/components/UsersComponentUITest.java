// package com.app.frontend.users.components;

// import static org.mockito.Mockito.mock;

// import java.io.ByteArrayInputStream;
// import java.io.ByteArrayOutputStream;
// import java.io.InputStream;
// import java.io.PrintStream;
// import java.lang.reflect.Field;
// import java.util.Scanner;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;
// import org.mockito.Mockito;

// import com.app.backend.common.responses.Response;
// import com.app.backend.common.responses.SuccessResponse;
// import com.app.backend.users.dtos.UserDTO;
// import com.app.backend.users.entities.UserEntity;
// import com.app.frontend.users.services.UsersServicesUI;

// public class UsersComponentUITest {
// private UsersServicesUI usersServicesUI;
// private UsersComponentUI usersComponentUI;
// private final PrintStream standardOut = System.out;
// private final ByteArrayOutputStream outputStreamCaptor = new
// ByteArrayOutputStream();

// @Before
// public void setUp() {
// this.usersServicesUI = mock(UsersServicesUI.class);
// this.usersComponentUI = new UsersComponentUI(usersServicesUI);
// System.setOut(new PrintStream(outputStreamCaptor));
// }

// @After
// public void tearDown() {
// System.setOut(standardOut);
// }

// @Test
// public void shouldCreateUser() {
// Response response;
// UserEntity expectedUser;
// UserDTO userDTO;

// expectedUser = new UserEntity("999999", "Alex Padilla", "alex@mail.com",
// "222222");
// userDTO = new UserDTO("Alex Padilla", "alex@mail.com", "222222");
// response = new SuccessResponse("User created", expectedUser);

// Mockito.when(usersServicesUI.create(userDTO)).thenReturn(response);

// // String userInput = convertInputString(userDTO);
// // mockInput(userInput);

// // this.usersComponentUI.create();

// }

// public void mockInput(String input) {
// InputStream in = new ByteArrayInputStream(input.getBytes());
// System.setIn(in);
// }

// private String convertInputString(UserDTO userDTO) {
// String input;

// input = userDTO.getName() + "\n";
// input += userDTO.getEmail() + "\n";
// input += userDTO.getPassword() + "\n";

// return input;
// }
// }

package com.app.backend.users.dtos;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.Test;

public class UserDTOTest {
  @Test
  public void testIsCreateUserDTO() {
    UserDTO userDTO;

    // Invalid email
    userDTO = new UserDTO("name", "email");
    assertFalse(userDTO.isCreateUserDTO());

    // Invalid name
    userDTO = new UserDTO("", "test@mail.com");
    assertFalse(userDTO.isCreateUserDTO());

    // Null email
    userDTO = new UserDTO(null, "test@mail.com");
    assertFalse(userDTO.isCreateUserDTO());

    userDTO = new UserDTO("name", "test@mail.com");
    assertTrue(userDTO.isCreateUserDTO());

    userDTO = new UserDTO("Alex", "alex@mail.com");
    assertTrue(userDTO.isCreateUserDTO());
  }

  @Test
  public void testIsUpdateUserDTO() {
    UserDTO userDTO;

    // Invalid email
    userDTO = new UserDTO("name", "email");
    assertFalse(userDTO.isUpdateUserDTO());

    // Invalid name
    userDTO = new UserDTO("", "test@mail.com");
    assertFalse(userDTO.isUpdateUserDTO());

    // Null email
    userDTO = new UserDTO(null, "test@mail.com");
    assertTrue(userDTO.isUpdateUserDTO());

    // Null email and name
    userDTO = new UserDTO(null, null);
    assertTrue(userDTO.isUpdateUserDTO());

    userDTO = new UserDTO("name", "test@mail.com");
    assertTrue(userDTO.isUpdateUserDTO());
  }
}

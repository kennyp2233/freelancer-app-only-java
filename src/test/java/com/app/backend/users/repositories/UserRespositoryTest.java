// package com.app.backend.users.repositories;

// import static org.junit.Assert.assertTrue;

// import java.util.Arrays;

// import org.junit.After;
// import org.junit.Before;
// import org.junit.Test;

// import com.app.backend.users.entities.UserEntity;
// import com.app.backend.users.repository.UsersRepository;

// public class UserRespositoryTest {
// private UsersRepository userRespository;
// private UserEntity userTest;

// @Before
// public void setUp() {
// this.userRespository = UsersRepository.getInstance();
// this.userTest = new UserEntity("111111", "John Doe", "john@mail.com",
// "123456");
// }

// @Test
// public void shouldInsertUser() {
// int initialRespositorySize;

// initialRespositorySize = this.userRespository.getAll().size();
// this.userRespository.insert(this.userTest);

// assertTrue(this.userRespository.getAll().size() == initialRespositorySize +
// 1);

// this.printRepository();
// }

// @Test
// public void shouldGetUserById() {
// UserEntity userToFind;

// this.userRespository.insert(this.userTest);

// userToFind = this.userRespository.getById(this.userTest.getId());

// assertTrue(this.userTest == userToFind);
// }

// @Test
// public void shouldUpdateAllDataUser() {
// UserEntity userAfterUpdate;
// UserEntity dataToUpdate;
// UserEntity userUpdated;

// // Insert test user to update and insert it into repository
// this.userRespository.insert(this.userTest);

// // Create data to update user and update it
// dataToUpdate = new UserEntity("444444", "Kenny Pinchao", "kenny@mail.com",
// "654321");
// userUpdated = this.userRespository.update(this.userTest.getId(),
// dataToUpdate);

// // Get user by prev user id from repository and check if it was updated
// userAfterUpdate = this.userRespository.getById(this.userTest.getId());
// assertTrue(userAfterUpdate == null);

// // Get updated user from repository and check if it was updated
// assertTrue(userUpdated.equals(dataToUpdate));
// }

// @Test
// public void shouldDeleteUser() {
// int sizeBeforeDelete;
// int sizeAfterDelete;
// UserEntity userDeleted;

// this.userRespository.insert(this.userTest);

// sizeBeforeDelete = this.userRespository.getAll().size();
// userDeleted = this.userRespository.delete(this.userTest.getId());
// sizeAfterDelete = this.userRespository.getAll().size();

// assertTrue(userDeleted == this.userTest);
// assertTrue(this.userRespository.getById(this.userTest.getId()) == null);
// assertTrue(sizeAfterDelete == sizeBeforeDelete - 1);
// }

// private void printRepository() {
// System.out.println(Arrays.toString(this.userRespository.getAll().toArray()));
// }

// @After
// public void tearDown() {
// this.userRespository.deleteAll();
// }
// }

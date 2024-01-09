/*
 * package com.movieapp.userservice.test.controller; import static
 * org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
 * import org.springframework.http.HttpStatus; import
 * org.springframework.http.ResponseEntity;
 * 
 * import com.movieapp.userservice.exception.UserNotFoundException; import
 * com.movieapp.userservice.model.UserDetails; import
 * com.movieapp.userservice.service.UserService; import
 * com.movieapp.userservice.controller.UserController;
 * 
 * @ExtendWith(MockitoExtension.class) class UserControllerTest {
 * 
 * @Mock private UserService userService;
 * 
 * @InjectMocks private UserController userController;
 * 
 * @Test void testRegisterUser() { UserDetails userDetailsToRegister = new
 * UserDetails(1, "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya",
 * "Sahoo", 9439208838L); UserDetails registeredUserDetails = new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * 
 * when(userService.registerUser(userDetailsToRegister)).thenReturn(
 * registeredUserDetails);
 * 
 * ResponseEntity<UserDetails> responseEntity =
 * userController.registerUser(userDetailsToRegister);
 * 
 * assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
 * assertEquals(registeredUserDetails, responseEntity.getBody()); }
 * 
 * @Test void testUpdateUser() throws UserNotFoundException { String userName =
 * "existingUser"; UserDetails userDetailsToUpdate = new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * UserDetails updatedUserDetails = new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * 
 * when(userService.updateUser(userName,
 * userDetailsToUpdate)).thenReturn(updatedUserDetails);
 * 
 * ResponseEntity<?> responseEntity = userController.updateUser(userName,
 * userDetailsToUpdate);
 * 
 * assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
 * assertEquals(updatedUserDetails, responseEntity.getBody()); }
 * 
 * 
 * }
 */
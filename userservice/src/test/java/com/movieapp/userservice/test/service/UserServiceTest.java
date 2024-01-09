/*
 * package com.movieapp.userservice.test.service; import static
 * org.junit.jupiter.api.Assertions.*; import static org.mockito.Mockito.*;
 * 
 * import java.util.Optional;
 * 
 * import org.junit.jupiter.api.Test; import
 * org.junit.jupiter.api.extension.ExtendWith; import org.mockito.InjectMocks;
 * import org.mockito.Mock; import org.mockito.junit.jupiter.MockitoExtension;
 * import org.springframework.kafka.core.KafkaTemplate;
 * 
 * import com.google.gson.Gson; import
 * com.movieapp.userservice.exception.UserNotFoundException; import
 * com.movieapp.userservice.model.AuthenticationRequest; import
 * com.movieapp.userservice.model.UserDetails; import
 * com.movieapp.userservice.repository.UserRepository; import
 * com.movieapp.userservice.service.UserServiceImpl;
 * 
 * @ExtendWith(MockitoExtension.class) class UserServiceImplTest {
 * 
 * @Mock private UserRepository userRepository;
 * 
 * @Mock private KafkaTemplate<String, String> kafkaTemplate;
 * 
 * @Mock private Gson gson;
 * 
 * @InjectMocks private UserServiceImpl userService;
 * 
 * UserDetails userDetails;
 * 
 * 
 * @Test void testRegisterUser() { UserDetails userDetails = new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * 
 * AuthenticationRequest authRequest = new
 * AuthenticationRequest(userDetails.getUserName(), userDetails.getPassword());
 * when(gson.toJson(authRequest)).thenReturn("jsonAuthRequest");
 * 
 * when(userRepository.save(userDetails)).thenReturn(userDetails);
 * 
 * UserDetails registeredUser = userService.registerUser(userDetails);
 * 
 * assertEquals(userDetails, registeredUser); verify(kafkaTemplate,
 * times(1)).send("usertopic", "jsonAuthRequest"); }
 * 
 * @Test void testUpdateUser() throws UserNotFoundException { String userName =
 * "existingUser"; UserDetails existingUserDetails =new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * UserDetails updatedUserDetails =new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * when(userRepository.findbyUserName(userName)).thenReturn(Optional.of(
 * existingUserDetails));
 * when(userRepository.save(existingUserDetails)).thenReturn(existingUserDetails
 * );
 * 
 * UserDetails updatedUser = userService.updateUser(userName,
 * updatedUserDetails);
 * 
 * assertEquals(updatedUserDetails, updatedUser); assertEquals("Sriya@00",
 * updatedUser.getPassword()); assertEquals("Sriya",
 * updatedUser.getFirstName()); assertEquals("Sahoo",
 * updatedUser.getLastName()); assertEquals("sriyat2011@gmail.com",
 * updatedUser.getEmail()); assertEquals(9439208838L,
 * updatedUser.getPhoneNumber()); }
 * 
 * @Test void testUpdateUser_UserNotFoundException() { String userName =
 * "nonExistingUser"; UserDetails updatedUserDetails = new UserDetails(1,
 * "sriya99","sriyat2011@gmail.com", "Sriya@00", "Sriya", "Sahoo", 9439208838L);
 * when(userRepository.findbyUserName(userName)).thenReturn(Optional.empty());
 * 
 * assertThrows(UserNotFoundException.class, () ->
 * userService.updateUser(userName, updatedUserDetails)); } }
 */
package com.dog.empire.services;



import com.dog.empire.exception.UserNotFoundException;
import com.dog.empire.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface UserService {
    // Save operation
    User saveUser(User user);

    //get by id
    public Optional<User> findById(Long userId);

    User findUserByUsername(String username) throws UserNotFoundException;

    // Read operation
    List<User> fetchUserList();
    public List<User> getAllUsers();

    // Update operation
    User updateUser(User user, Long userId);

    // Delete operation
    void deleteUserById(Long userId);
  //  ResponseEntity<?> getAllUserAchat(Long userId);
}

package com.dog.empire.dao;

import com.dog.empire.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserDao extends JpaRepository<User, Long> {
    Optional<User> findUsersByUsername(String username);
    Optional<User> findUserByUserId(Long userId);

  /*  List<User> findUserByAchatId(User user);*/

}

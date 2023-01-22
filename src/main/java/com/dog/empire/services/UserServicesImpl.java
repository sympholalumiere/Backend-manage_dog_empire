package com.dog.empire.services;

import com.dog.empire.dao.AchatDao;
import com.dog.empire.dao.UserDao;
import com.dog.empire.exception.AnimalNotFoundException;
import com.dog.empire.exception.UserNotFoundException;
import com.dog.empire.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserServicesImpl implements UserService{
    private UserDao userDao;
    private AchatDao achatDao;

    @Autowired
    public UserServicesImpl(UserDao userDao,AchatDao achatDao) {
        this.userDao = userDao;
        this.achatDao = achatDao;
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public Optional<User> findById(Long userId) {
        return userDao.findById(userId);
    }

    @Override
    public User findUserByUsername(String username) throws UserNotFoundException {
        Optional<User> user = userDao.findUsersByUsername(username);
        if(user.isPresent()) {
            return user.get();
        } else {
            throw new UserNotFoundException("user avec nom : "+username+" n'exixte pas");
        }
    }

    @Override
    public List<User> fetchUserList() {
        return (List<User>)
                userDao.findAll();
    }

    @Override
    public List<User> getAllUsers() {
        return userDao.findAll();
    }

    @Override
    public User updateUser(User user, Long userId) {
        User userDB
                = userDao.findById(userId).get();
        return userDao.save(userDB);
    }

    @Override
    public void deleteUserById(Long userId) {
        userDao.deleteById(userId);

    }



   /* @Override
    public ResponseEntity<?> getAllUserAchat(Long userId) {
        Optional<User> user = userDao.findById(userId);
        if (user.isPresent()){
            return ResponseEntity.status(200).body(achatDao.findAchatByUser(userId));
        }else {
            return ResponseEntity.status(401).body("User with this ID doesn't exist");
        }
    }*/
}

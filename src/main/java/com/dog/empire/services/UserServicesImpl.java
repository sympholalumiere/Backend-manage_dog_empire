package com.dog.empire.services;

import com.dog.empire.dao.UserDao;
import com.dog.empire.exception.AnimalNotFoundException;
import com.dog.empire.exception.UserNotFoundException;
import com.dog.empire.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Component
@Service
public class UserServicesImpl implements UserService{
    private UserDao userDao;

    @Autowired
    public UserServicesImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public User saveUser(User user) {
        return userDao.save(user);
    }

    @Override
    public Optional<User> findById(Long id) {
        return userDao.findById(id);
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
    public User updateUser(User user, Long iduser) {
        User userDB
                = userDao.findById(iduser).get();
        return userDao.save(userDB);
    }

    @Override
    public void deleteUserById(Long iduser) {
        userDao.deleteById(iduser);

    }
}

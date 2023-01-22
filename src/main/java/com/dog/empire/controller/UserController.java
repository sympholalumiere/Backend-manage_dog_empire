package com.dog.empire.controller;

import com.dog.empire.model.User;
import com.dog.empire.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")

@Component
@RestController
public class UserController {
    private UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }
    //creer une methode de recuperation de tous les animaux depuis la BD

    @GetMapping(value ="user/liste")
    public List<User> getAllUsers(){
        List<User> liste= new ArrayList<>();
        userService.fetchUserList().forEach(liste::add);
        return liste;
    }

    // Save operation
    @PostMapping("user/ajout")

    public User createUser(
            @Validated @RequestBody User user)
    {
        return userService.saveUser(user);
    }
    //
    @RequestMapping(value="user/{id}",method=RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Optional<User> getUserlById(@PathVariable("id") Long userId) {

        return userService.findById(userId);
    }

    // tous les animaux
    @GetMapping("user/users")

    public List<User> fetchUserList()
    {
        return userService.fetchUserList();
    }

    // Update operation
    @PutMapping("user/modifie_user/{userId}")

    public User updateUser(@RequestBody User user, @PathVariable("id") Long userId)
    {
        return userService.updateUser(
                user, userId);
    }

    // Delete operation
    @DeleteMapping("user/{id}")

    public String deleteUserById(@PathVariable("id") Long iduser)
    {
        userService.deleteUserById( iduser);
        return "Deleted Successfully";
    }
}

package com.example.exercie1.Controller;

import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDto;
import com.example.exercie1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody @Validated UserEntity params) {
    // create a new user
        UserEntity userEntity = new UserEntity(params.getEmail(), params.getPassword());
        return userService.createUser(userEntity);
    }

    @GetMapping("/users/{userId}")
    public Optional<UserDto> getUserById(@PathVariable String userId) {
    // get and return user with id 'userId'
        return userService.getUserById(userId);
    }

    @PutMapping("/users/edit/{userId}")
    public UserEntity updateUser(@PathVariable String userId, @RequestBody UserCreationParams params) {
        return null;
    }

    @DeleteMapping("/users/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return true;
    }
}

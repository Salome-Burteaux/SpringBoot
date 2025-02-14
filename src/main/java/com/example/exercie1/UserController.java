package com.example.exercie1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserCreationParams params) {
    // TODO - actually create a new user
        return null;
    }

    @GetMapping("/users/{userId}")
    public UserDto getUser(@PathVariable String userId) {
    // TODO - actually get and return user with id 'userId'
        return null;
    }

    @PutMapping("/users/edit/{userId}")
    public UserDto editUser(@PathVariable String userId, @RequestBody UserCreationParams params) {
        return null;
    }

    @DeleteMapping("/users/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return false;
    }
}

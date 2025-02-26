package com.example.exercie1.Controller;

import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDto;
import com.example.exercie1.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/users")
    public UserDto createUser(@RequestBody @Validated UserCreationParams params) {
    // create a new user
        UserCreationParams userCreationParams = new UserCreationParams(params.getEmail(), params.getPassword());
        UserDto userDto = new UserDto(params.getId(), params.getEmail());
        return userService.createUser(userDto, params.getPassword());
    }

    @GetMapping("/users/{userId}")
    public UserDto getUserById(@PathVariable String userId) {
    // get and return user with id 'userId'
        return userService.getUserById(userId);
    }

    @PutMapping("/users/edit/{userId}")
    public UserDto updateUser(@PathVariable String userId, @RequestBody UserCreationParams params) {
        return userService.updateUser(userId, params);
    }

    @DeleteMapping("/users/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return userService.deleteUser(userId);
    }

    @GetMapping("/api/users/validate")
    public ResponseEntity<Void> validateUser(@RequestHeader("X-UserId") String userId) {
        boolean isValid = userService.isValidUser(userId);
        if (isValid) {
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}

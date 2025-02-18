package com.example.exercie1.Controller;

import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDto;
import com.example.exercie1.Service.UserService;
import com.example.exercie1.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

//    @Autowired
//    UserService userService;

    @Autowired
    UserEntityRepository userEntityRepository;

    @PostMapping("/users")
    public UserEntity createUser(@RequestBody UserEntity params) {
    // create a new user
        UserEntity userEntity = new UserEntity(params.email, params.password);
        return this.userEntityRepository.save(userEntity);
    }

    @GetMapping("/users/{userId}")
    public UserEntity getUser(@PathVariable String userId) {
    // get and return user with id 'userId'
        return this.userEntityRepository.findById(userId).orElse(null);
    }

    @PutMapping("/users/edit/{userId}")
    public UserEntity editUser(@PathVariable String userId, @RequestBody UserCreationParams params) {
        return this.userEntityRepository.findById(userId).orElse(null);
    }

    @DeleteMapping("/users/delete/{userId}")
    public boolean deleteUser(@PathVariable String userId) {
        return true;
    }
}

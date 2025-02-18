package com.example.exercie1.Service;

import com.example.exercie1.Entity.User;
import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserDto;

import java.util.Optional;


public interface UserService {

    UserEntity createUser(UserEntity userEntity);
    Optional<UserDto> getUserById(String id);
    User updateUser(User user);
    User deleteUser(String id);

}

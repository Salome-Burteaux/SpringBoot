package com.example.exercie1.Service;

import com.example.exercie1.Entity.User;
import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDto;

import java.util.Optional;


public interface UserService {

    UserDto createUser(UserDto userDto, String password);
    Optional<UserDto> getUserById(String id);
    UserDto updateUser(String userId, UserCreationParams params);
    boolean deleteUser(String id);


}

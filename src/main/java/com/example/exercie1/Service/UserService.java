package com.example.exercie1.Service;

import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDto;

public interface UserService {

    UserDto getUser(String id);
    UserCreationParams createUser(UserCreationParams params);
    UserDto editUser(UserDto userDto);
    boolean deleteUser(String id);

}

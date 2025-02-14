package com.example.exercie1;

public interface UserService {

    UserDto getUser(String id);
    UserCreationParams createUser(UserCreationParams params);
    UserDto editUser(UserDto userDto);
    boolean deleteUser(String id);

}

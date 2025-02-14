package com.example.exercie1;

import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public UserCreationParams createUser(UserCreationParams userCreationParams) {
        return userCreationParams;
    }

    @Override
    public UserDto editUser(UserDto userDto) {
        return userDto;
    }

    @Override
    public UserDto getUser(String id) {
        return ;
    }

    @Override
    public boolean deleteUser(String id) {
        return true;
    }
}

package com.example.exercie1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;


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
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        return true;
    }

}

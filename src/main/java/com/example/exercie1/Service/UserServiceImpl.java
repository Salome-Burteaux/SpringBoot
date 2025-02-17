package com.example.exercie1.Service;

import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDao;
import com.example.exercie1.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

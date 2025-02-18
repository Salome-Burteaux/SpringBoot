package com.example.exercie1.Service;

import com.example.exercie1.Entity.User;
import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserDao;
import com.example.exercie1.UserDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity createUser(UserEntity userEntity) {
        return userDao.upsert(userEntity);
    }

    @Override
    public Optional<UserDto> getUserById(String id) {
        Optional<UserEntity> user  = userDao.findById(id);
        return Optional.of(new UserDto(user.get().getEmail(), user.get().getId()));
    }

    @Override
    public User updateUser(User user) {
        return null;
    }

    @Override
    public User deleteUser(String id) {
        return null;
    }




}

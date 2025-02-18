package com.example.exercie1.Service;

import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserDao;
import com.example.exercie1.UserDto;
import com.example.exercie1.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.stream.Stream;

@Service
public class JpaUserDao implements UserDao {

    @Autowired
    private UserEntityRepository userEntityRepository;


    @Override
    public Stream<UserDto> findAll() {
        return Stream.empty();
    }

    @Override
    public Optional<UserEntity> findById(String userId) {
        return userEntityRepository.findById(userId);
    }

    @Override
    public UserEntity upsert(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    @Override
    public void delete(String userId) {

    }
}

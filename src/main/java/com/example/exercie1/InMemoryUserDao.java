package com.example.exercie1;

import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
public class InMemoryUserDao implements UserDao {


    @Override
    public Stream<UserDto> findAll() {
        return Stream.empty();
    }

    @Override
    public Optional<UserDto> findById(UUID userId) {
        return Optional.empty();
    }

    @Override
    public UserDto upsert(UserDto user) {
        return null;
    }

    @Override
    public void delete(UUID userId) {

    }
}

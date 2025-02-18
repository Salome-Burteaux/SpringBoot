package com.example.exercie1;

import com.example.exercie1.Entity.UserEntity;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity, String> {

    @Override
    <S extends UserEntity> List<S> findAll(Example<S> example);

    @Override
    Optional<UserEntity> findById(String aString);

    @Override
    <S extends UserEntity> S save(S entity);

    @Override
    void delete(UserEntity entity);
}

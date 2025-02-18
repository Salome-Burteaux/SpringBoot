package com.example.exercie1;


import com.example.exercie1.Entity.UserEntity;
import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {

    //Stream : retourner un flux (Stream) de tous les utilisateurs disponibles dans la source de données
    @NotNull Stream<UserDto> findAll();

    //recherche un utilisateur par son identifiant unique
    Optional<UserEntity> findById(@NotNull String userId);

    //insère ou met à jour un utilisateur "upsert" = "update" + "insert"
    UserEntity upsert(@NotNull UserEntity userEntity);

    //supprime utilisateur par son Id
    void delete(@NotNull String userId);

}

package com.example.exercie1;


import jakarta.validation.constraints.NotNull;

import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

public interface UserDao {

    //Stream : retourner un flux (Stream) de tous les utilisateurs disponibles dans la source de données
    @NotNull Stream<UserDto> findAll();

    //recherche un utilisateur par son identifiant unique
    Optional<UserDto> findById(@NotNull UUID userId);

    //insère ou met à jour un utilisateur "upsert" = "update" + "insert"
    @NotNull UserDto upsert(@NotNull UserDto user);

    //supprime utilisateur par son Id
    void delete(@NotNull UUID userId);

}

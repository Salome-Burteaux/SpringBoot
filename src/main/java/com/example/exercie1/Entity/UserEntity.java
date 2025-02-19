package com.example.exercie1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

import java.util.UUID;

@Entity
public class UserEntity {


    private @Id String id;
    private @NotEmpty @Email String email;
    private @NotEmpty String password;

    public UserEntity() {

    }

    public UserEntity(@NotEmpty @Email String email, @NotEmpty String password) {

        this.email = email;
        this.password = password;
        this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}

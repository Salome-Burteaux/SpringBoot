package com.example.exercie1.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class User {

    @Id
    public int id;
    public @Email @NotEmpty String email;
    public @NotEmpty @Min(8) String password;



    public User(int id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public User() {

    }
}

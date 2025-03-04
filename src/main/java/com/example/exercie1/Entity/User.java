package com.example.exercie1.Entity;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

public class User {

    @Id
    private int id;
    private @Email(message = "L'email doit être valide") @NotNull(message = "L'email ne doit pas être nul") String email;
    private @NotNull @Size(min = 8, message = "Le mot de passe doit comporter au moins 8 caractères") String password;
    private @NotNull String name;
    private String role;



    public User(int id, String email, String password, String name, String role) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.name = name;
        this.role = role != null && role.equals("ADMIN") ? "ADMIN" : "USER";

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getRole() { return role; }

    public void setRole(String role) { this.role = role; }
}

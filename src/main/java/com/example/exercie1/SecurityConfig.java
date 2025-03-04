package com.example.exercie1;


import com.example.exercie1.utils.JwtFilter;
import com.example.jwtsecurity.util.JwtFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

//définit comment les requêtes HTTP doivent être sécurisées et authentifiées

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true, securedEnabled = true)
public class SecurityConfig {

    // Injection des dépendances nécessaires
    private final AuthenticationConfiguration authenticationConfiguration;
    private final JwtFilter jwtFilter;
    private final UserDetailsService userDetailsService;

    // Constructeur pour initialiser les dépendances
    public SecurityConfig(UserDetailsService userDetailsService,
                          AuthenticationConfiguration authenticationConfiguration, JwtFilter jwtFilter) {
        this.userDetailsService = userDetailsService;
        this.authenticationConfiguration = authenticationConfiguration;
        this.jwtFilter = jwtFilter;
    }

    //définit des règles d'autorisation pour différents chemins d'URL et en ajoutant un filtre JWT pour gérer l'authentification
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .csrf(AbstractHttpConfigurer::disable) // Désactive la protection CSRF
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/**").permitAll() // Autorise toutes les requêtes vers /auth/** sans authentification
                        .requestMatchers("/test/admin").hasRole("ADMIN") // Seuls les utilisateurs avec le rôle ADMIN peuvent accéder à /test/admin
                        .requestMatchers("/test/user").hasRole("USER") // Seuls les utilisateurs avec le rôle USER peuvent accéder à /test/user
                        .anyRequest().authenticated() // Toutes les autres requêtes nécessitent une authentification
                )
                .addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class) // Ajoute le filtre JWT avant le filtre d'authentification par défaut
                .build();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService); // Utilise le service de détails utilisateur pour l'authentification
        authProvider.setPasswordEncoder(passwordEncoder()); // Utilise l'encodeur de mot de passe
        return authProvider;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Retourne un encodeur de mot de passe délégué
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager() throws Exception {
        return authenticationConfiguration.getAuthenticationManager(); // Retourne le gestionnaire d'authentification
    }

    // Crée des utilisateurs en mémoire pour des tests
    @Bean
    public static UserDetailsService userDetailsService() {
        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();
        userDetailsManager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("admin")
                        .password("admin123")
                        .roles("ADMIN")
                        .build()
        );
        userDetailsManager.createUser(
                User.withDefaultPasswordEncoder()
                        .username("user")
                        .password("user123")
                        .roles("USER")
                        .build()
        );
        return userDetailsManager;
    }
}


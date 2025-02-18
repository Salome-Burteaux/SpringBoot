package com.example.exercie1.Service;

import com.example.exercie1.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JpaUserDao {

    @Autowired
    private UserEntityRepository userRepository;



}

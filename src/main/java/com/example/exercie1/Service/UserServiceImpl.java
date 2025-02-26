package com.example.exercie1.Service;

import com.example.exercie1.Entity.User;
import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserCreationParams;
import com.example.exercie1.UserDao;
import com.example.exercie1.UserDto;
import com.example.exercie1.UserEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserEntityRepository userEntityRepository;



    @Override
    public UserDto createUser(UserDto userDto, String password) {
        // Transformer UserDto en entité UserEntity avec le mot de passe
        UserEntity userEntity = new UserEntity(userDto.getEmail(), password);

        // Sauvegarder l'entité UserEntity dans la base de données
        UserEntity savedUserEntity = userEntityRepository.save(userEntity);

        // Retourner un UserDto basé sur l'entité sauvegardée
        return new UserDto(String.valueOf(savedUserEntity.getId()), savedUserEntity.getEmail());
    }

    @Override
    public UserDto getUserById(String id) {
        UserEntity userEntity = userEntityRepository.findById(id).orElse(null);
        return new UserDto(String.valueOf(userEntity.getId()), userEntity.getEmail());

//        Optional<UserEntity> userEntity = userEntityRepository.findById(id);
//        return userEntity.map(u -> new UserDto(String.valueOf(u.getId()), u.getEmail()));
    }

    @Override
    public UserDto updateUser(String userId, UserCreationParams params) {
        Optional<UserEntity> existingUser = userEntityRepository.findById(userId);
        if (existingUser.isPresent()) {
            UserEntity userEntity = existingUser.get();
            userEntity.setEmail(params.getEmail());
            userEntity.setPassword(params.getPassword());
            UserEntity updatedUserEntity = userEntityRepository.save(userEntity);
            return new UserDto(String.valueOf(updatedUserEntity.getId()), updatedUserEntity.getEmail());
        }
        return null;
    }

    @Override
    public boolean deleteUser(String id) {
        Optional<UserEntity> userEntity = userEntityRepository.findById(id);
        if (userEntity.isPresent()) {
            userEntityRepository.delete(userEntity.get());
            return true;
        }
        return false;
    }

    @Override
    public boolean isValidUser(String userId) {
        return userEntityRepository.existsById(userId);
    }
}

package com.example.exercie1.Service;

import com.example.exercie1.Entity.UserEntity;
import com.example.exercie1.UserDao;
import com.example.exercie1.UserDto;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Stream;

@Service
@Primary
public class JdbcUserDao {
//
//    public NamedParameterJdbcTemplate namedParameterJdbcTemplate;
//
//
//    @Override
//    public Stream<UserDto> findAll() {
//        String sql = "SELECT id, email FROM users";
//        List<UserDto> users = namedParameterJdbcTemplate.query(sql, (rs, rowNum) ->
//                new UserDto(rs.getString("id"), rs.getString("email"))
//        );
//        return users.stream();
//    }
//
//    @Override
//    public Optional<UserDto> findById(UUID userId) {
//        String sql = "SELECT id, email FROM users WHERE id = :id";
//        SqlParameterSource namedParameters = new MapSqlParameterSource("id", userId.toString());
//        UserDto user = namedParameterJdbcTemplate.queryForObject(sql, namedParameters, (rs, rowNum) ->
//                new UserDto(rs.getString("id"), rs.getString("email"))
//        );
//        return Optional.ofNullable(user);
//    }
//
//    @Override
//    public UserEntity upsert(UserDto user) {
//        String sql = "INSERT INTO users (id, email) VALUES (:id, :email) " +
//                "ON DUPLICATE KEY UPDATE email = :email";
//        SqlParameterSource namedParameters = new MapSqlParameterSource()
//                .addValue("id", user.getId().toString())
//                .addValue("email", user.getEmail());
//        namedParameterJdbcTemplate.update(sql, namedParameters);
//        return user;
//    }
//
//    @Override
//    public void delete(UUID userId) {
//        String sql = "DELETE FROM users WHERE id = :id";
//        SqlParameterSource namedParameters = new MapSqlParameterSource("id", userId.toString());
//        namedParameterJdbcTemplate.update(sql, namedParameters);
//    }
}

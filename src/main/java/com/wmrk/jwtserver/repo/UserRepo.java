package com.wmrk.jwtserver.repo;

import com.wmrk.jwtserver.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {
    Optional<User> findUserByLoginIgnoreCase(String login);
}

package com.wmrk.todo.jwtserver.repo;

import com.wmrk.todo.jwtserver.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepo extends CrudRepository<User, Integer> {
    Optional<User> findUserByLoginIgnoreCase(String login);
    boolean existsByLoginIgnoreCase(String name);
}

package com.wmrk.jwtserver.service;

import com.wmrk.jwtserver.repo.UserRepo;
import lombok.NonNull;
import com.wmrk.jwtserver.entity.Role;
import com.wmrk.jwtserver.entity.User;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;
    //private final List<User> users;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
//        this.users = List.of(
//                new User(1277, "anton", "1234", Collections.singleton(Role.USER)),
//                new User(7853, "ivan", "12345", Collections.singleton(Role.ADMIN))
//        );
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return userRepo.findUserByLoginIgnoreCase(login);
//        return users.stream()
//                .filter(user -> login.equals(user.getLogin()))
//                .findFirst();
    }

}
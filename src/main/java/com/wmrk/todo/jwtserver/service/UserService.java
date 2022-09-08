package com.wmrk.todo.jwtserver.service;

import com.wmrk.todo.domain.Role;
import com.wmrk.todo.jwtserver.entity.User;
import com.wmrk.todo.jwtserver.exception.EntityExistsException;
import com.wmrk.todo.jwtserver.repo.UserRepo;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public Optional<User> getByLogin(@NonNull String login) {
        return userRepo.findUserByLoginIgnoreCase(login);
    }

    @Transactional
    public User create(User newUser) throws EntityExistsException {
        if (userRepo.existsByLoginIgnoreCase(newUser.getLogin())) {
            throw new EntityExistsException();
        }
        
        newUser.setRoles(Collections.singleton(Role.ROLE_USER));
        if(newUser.getLogin().equalsIgnoreCase(Role.ROLE_ADMIN.getAuthority())) {
            newUser.setRoles(Collections.singleton(Role.ROLE_ADMIN));
        }

        newUser.setPassword(passwordEncoder.encode(newUser.getPassword()));

        newUser.setId(0);
        userRepo.save(newUser);
        return newUser;
    }

}
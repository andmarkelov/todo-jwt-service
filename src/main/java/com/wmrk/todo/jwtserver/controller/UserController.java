package com.wmrk.todo.jwtserver.controller;

import com.wmrk.todo.jwtserver.entity.User;
import com.wmrk.todo.jwtserver.exception.EntityExistsException;
import com.wmrk.todo.jwtserver.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping
    public User register(@RequestBody User newUser) throws EntityExistsException {
        return userService.create(newUser);
    }
}

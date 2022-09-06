package com.wmrk.jwtserver.controller;

import com.wmrk.jwtserver.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/user")
@RequiredArgsConstructor
public class UserController {
    @PostMapping
    public User register() {
         return null;
    }
}

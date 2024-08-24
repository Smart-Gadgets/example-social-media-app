package com.social.media.app_exmaple.controller;

import com.social.media.app_exmaple.model.dto.UserReq;
import com.social.media.app_exmaple.services.UserService;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class User {

    private final UserService userService;

    @Autowired
    public User(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(path = "/user")
    public @ResponseBody UserReq createUser(@RequestBody UserReq user) throws BadRequestException {
        return userService.createUser(user);
    }
}

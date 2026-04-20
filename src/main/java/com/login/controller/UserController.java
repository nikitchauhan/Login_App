package com.login.controller;


import com.login.domain.UserDetails;
import com.login.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/app/saveUser")
    public ResponseEntity<?> createUser(UserDetails userDetails)
    {

        return userService.saveUser(userDetails);
    }



}

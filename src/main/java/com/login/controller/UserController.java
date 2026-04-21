package com.login.controller;



import com.login.Entity.UserDetails;
import com.login.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/app/saveUser")
    public ResponseEntity<?> createUser(@RequestBody UserDetails userDetails)
    {

        return userService.saveUserDetails(userDetails);
    }

    @GetMapping("/app/getUserDetails")
    public List<UserDetails> getUserDetails()
    {

        return userService.getUserDetails();
    }



}

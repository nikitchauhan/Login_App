package com.login.controller;



import com.login.Entity.UserDetails;
import com.login.service.UserService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/app")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;


    @PostMapping("/saveUser")
    public ResponseEntity<?> createUser(@RequestBody UserDetails userDetails)
    {

        return userService.saveUserDetails(userDetails);
    }

    @GetMapping("/getUserDetails")
    public List<UserDetails> getUserDetails()
    {

        return userService.getUserDetails();
    }


    @GetMapping("/getUserDetails/{userId}")
    public Optional<UserDetails> getUserDetailsById(@PathVariable Long userId)
    {

        return userService.getUserDetailsbyId(userId);
    }






}

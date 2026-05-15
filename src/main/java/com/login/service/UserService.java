package com.login.service;


import com.login.Entity.UserDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


public interface UserService {



     ResponseEntity<?> saveUserDetails(UserDetails userDetails);

     List<UserDetails> getUserDetails();

     Optional<UserDetails> getUserDetailsbyId(Long userId);
}

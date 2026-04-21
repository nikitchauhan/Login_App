package com.login.service;


import com.login.Entity.UserDetails;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface UserService {



     ResponseEntity<?> saveUserDetails(UserDetails userDetails);

     List<UserDetails> getUserDetails();
}

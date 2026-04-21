package com.login.service.impl;



import com.login.Entity.UserDetails;
import com.login.exception.InvalidUserDetailsException;
import com.login.repository.UserRepository;
import com.login.service.UserService;
import com.login.validtor.UserDetailsValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDetailsValidator userDetailsValidator;
    @Autowired
    private UserRepository userRepo;

    public ResponseEntity<?> saveUserDetails(UserDetails userDetails)
    {

      try {
          userDetailsValidator.validateUserDetails(userDetails);

          userRepo.save(userDetails);
      }
      catch (Exception e)
      {
      System.out.println("Exception");
      }

        return null;
    }

    @Override
    public List<UserDetails> getUserDetails() {
       System.out.println("Hello user" );
        List<UserDetails> userlist = userRepo.findAll();
        //return new ResponseEntity<>(userlist, HttpStatus.OK);
        return userlist;
    }


}

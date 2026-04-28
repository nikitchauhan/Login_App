package com.login.service.impl;



import com.login.Entity.UserDetails;
import com.login.constant.Constant;
import com.login.exception.InvalidUserDetailsException;
import com.login.repository.UserRepository;
import com.login.service.UserService;
import com.login.validtor.UserDetailsValidator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
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

          return  new ResponseEntity<>(userDetails, HttpStatus.OK);
      }
      catch (Exception e)
      { log.info("Exception Triggered");
       throw  new InvalidUserDetailsException(Constant.INVALID_USER_DETAILS,userDetails.getFirstName());

      }


    }

    @Override
    public List<UserDetails> getUserDetails() {
       System.out.println("Hello user" );
        List<UserDetails> userlist = userRepo.findAll();
        //return new ResponseEntity<>(userlist, HttpStatus.OK);
        return userlist;
    }


}

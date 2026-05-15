package com.login.service.impl;



import com.login.Entity.AddressDetails;
import com.login.Entity.UserDetails;
import com.login.constant.Constant;
import com.login.exception.InvalidUserDetailsException;
import com.login.exception.UserNotFoundException;
import com.login.repository.UserRepository;
import com.login.service.UserService;
import com.login.validtor.UserDetailsValidator;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
          AddressDetails address = userDetails.getAddress();

          address.setUser(userDetails);
          address.setUserId(userDetails.getUserId());
          userDetails.setAddress(address);
          userRepo.save(userDetails);

          return  new ResponseEntity<>(userDetails, HttpStatus.OK);
      }
      catch (Exception e)
      { log.info("Exception Triggered");
       throw  new InvalidUserDetailsException(Constant.INVALID_USER_DETAILS,userDetails.getFirstName());

      }


    }


    public List<UserDetails> getUserDetails() {
       System.out.println("Hello user" );
  List<UserDetails>  result =userRepo.findAll();
        return  result;

    }

       public Optional<UserDetails> getUserDetailsbyId(Long userId)
       {
              Optional<UserDetails> result=userRepo.findById(userId);

              if(userId==null)
              {
                 throw new  UserNotFoundException(Constant.NO_USER_FOUND,Constant.NOT_FOUND,null, null);
              }
             return userRepo.findById(userId);

       }


}

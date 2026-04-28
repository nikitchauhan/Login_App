package com.login.validtor;

import com.login.Entity.UserDetails;
import com.login.exception.InvalidUserDetailsException;
import org.springframework.stereotype.Component;

@Component
public class UserDetailsValidator {


     public void validateUserDetails(UserDetails userDetails) throws Exception {

          if(userDetails.getFirstName().length()>5)
          {
               throw new InvalidUserDetailsException("First name should not be more than 6 characters",userDetails.getFirstName());

          }



     }
}

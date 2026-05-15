package com.login.service.impl;



import com.login.Entity.UserDetails;
import com.login.service.LoginService;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

  public String doLogin(UserDetails userDetails)
  {

      return "User has logged-in Successfully";
  }

}

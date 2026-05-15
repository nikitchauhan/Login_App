package com.login.controller;


import com.login.Entity.UserDetails;
import com.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/app")
public class LoginController {


   @Autowired
   LoginService loginService;

   @PostMapping("/dologin")
   public String  userLogin(UserDetails userDetails)
   {
      return loginService.doLogin(userDetails);
   }

}

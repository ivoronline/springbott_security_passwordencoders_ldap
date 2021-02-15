package com.ivoronline.springbott_security_passwordencoders_ldap.controllers;

import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MyController {

  @ResponseBody
  @RequestMapping("/EncodePassword")
  public String encodePassword(@RequestParam String password) {

    //GET PASSWORD ENCODER
    PasswordEncoder ldap = new LdapShaPasswordEncoder();

    //ENCODE PASSWORD
    String encodedPassword = ldap.encode(password);

    //RETURN ENCODED PASSWORD
    return encodedPassword;

  }

  @ResponseBody
  @RequestMapping("/Hello")
  public String hello() {
    return "Hello from Controller";
  }

}

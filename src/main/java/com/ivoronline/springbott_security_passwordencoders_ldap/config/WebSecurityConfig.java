package com.ivoronline.springbott_security_passwordencoders_ldap.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.LdapShaPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

  //====================================================================
  // PASSWORD ENCODER
  //====================================================================
  @Bean
  PasswordEncoder passwordEncoder() {
    return new LdapShaPasswordEncoder();
  }

  //====================================================================
  // CONFIGURE
  //====================================================================
  @Override
  protected void configure(HttpSecurity httpSecurity) throws Exception {
    httpSecurity.authorizeRequests().antMatchers("/EncodePassword").permitAll(); //Anonymous     Access
    httpSecurity.authorizeRequests().anyRequest().authenticated();               //Authenticated Access
    httpSecurity.formLogin();                                                    //Default Login Form
  }

}

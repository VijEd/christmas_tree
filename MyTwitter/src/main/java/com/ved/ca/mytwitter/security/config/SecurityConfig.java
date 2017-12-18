package com.ved.ca.mytwitter.security.config;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableAutoConfiguration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  DataSource dataSource;

  @Autowired
  private MyBasicAuthenticationEntryPoint authenticationEntryPoint;

  @Autowired
  public void configureGlobal(AuthenticationManagerBuilder auth) 
      throws Exception {

    auth.jdbcAuthentication().dataSource(dataSource)
    .usersByUsernameQuery(
        "select username,password, enabled from test_schema.users where username=? ")
    .authoritiesByUsernameQuery(
        "select username, role from test_schema.user_roles where username=?");
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    .antMatchers("/admin", "/h2_console/**").hasRole("ADMIN")
    .antMatchers("/securityNone").permitAll()
    .anyRequest().authenticated()
    .and()
    .httpBasic()
    .authenticationEntryPoint(authenticationEntryPoint);

    http.csrf().disable();
    http.headers().frameOptions().disable();
  }

}


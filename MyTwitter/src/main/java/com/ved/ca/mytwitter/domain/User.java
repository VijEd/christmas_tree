package com.ved.ca.mytwitter.domain;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class User implements Serializable {
   
   /**
   * 
   */
   private static final long serialVersionUID = 1L;
   
   @JsonIgnore
   private int userId;
   private String userName;
   @JsonIgnore
   private String enabled;
   private String emailId;
   @JsonIgnore
   private String password;

    public User() {
    }

    public User(int userId, String username, String enabled, String emailId, String password) {
        this.userId = userId;
        this.userName = username;
        this.enabled =  enabled;
        this.emailId = emailId;
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", username='" + userName + '\'' +
                ", enabled='" + enabled + '\'' +
                ", emailId='" + emailId + '\'' +
                '}';
    }

    public int getUserId() {
      return userId;
    }

    public void setUserId(int userId) {
      this.userId = userId;
    }

    public String getUserName() {
      return userName;
    }

    public void setUserName(String userName) {
      this.userName = userName;
    }

    public String getEnabled() {
      return enabled;
    }

    public void setEnabled(String enabled) {
      this.enabled = enabled;
    }

    public String getEmailId() {
      return emailId;
    }

    public void setEmailId(String emailId) {
      this.emailId = emailId;
    }

    public String getPassword() {
      return password;
    }

    public void setPassword(String password) {
      this.password = password;
    }
}



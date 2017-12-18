package com.ved.ca.mytwitter.controller;

import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.ved.ca.mytwitter.domain.Message;
import com.ved.ca.mytwitter.domain.User;
import com.ved.ca.mytwitter.domain.UserFollower;
import com.ved.ca.mytwitter.mappers.UserMapper;

@RestController
public class UserController {

  private static final Logger _logger = LoggerFactory.getLogger(UserController.class);
  
  @Autowired
  private UserMapper userMapper;
  
    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping(path="/user/followers", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getFollowers() {
        return new ResponseEntity<>(userMapper.findFollowers(getUserId()),HttpStatus.OK);
    }
    
    @RequestMapping(path="/user/followees", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<User>> getFollowees() {
        return new ResponseEntity<>(userMapper.findUsersFollowing(getUserId()),HttpStatus.OK);
    }
    
    @RequestMapping(path="/user/add/{followerid}", method = RequestMethod.POST, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<String> addFollower(@PathVariable("followerid") Integer followerid) {
        try { 
          userMapper.addFollower(getUserId(), followerid);
        }catch(Exception exp) {
          _logger.error("Error in addFollower : message "+exp.getMessage());
          return new ResponseEntity<String>("Failed Adding Follower",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<String>("Successfully Added Follower",HttpStatus.OK);
    }
    
    @RequestMapping(path="/messages", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<Message>> getMessages(@RequestParam(value = "search", required = false, defaultValue = "") String keyword) {
        return new ResponseEntity<>(userMapper.findMessages(getUserId(), keyword),HttpStatus.OK);
    }
    
    @RequestMapping(path="/user/unfollow/{followerid}", method = RequestMethod.DELETE, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public ResponseEntity<String> deleteFollower( @PathVariable("followerid") Integer followerid) {
      try { 
        userMapper.deleteFollower(getUserId(), followerid);
      }catch(Exception exp) {
        _logger.error("Error in deleteFollower : message "+exp.getMessage());
        return new ResponseEntity<String>("Failed Adding Follower",HttpStatus.BAD_REQUEST);
      }
      return new ResponseEntity<String>("Successfully unfollowed another user",HttpStatus.OK);
  }
    
    @RequestMapping(path="/user/popularUserInfo", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Collection<UserFollower>> getPopularUserWithFollowers() {
        return new ResponseEntity<>(userMapper.getPopularUserWithFollowers(),HttpStatus.OK);
    }
    
    //TODO - need to use UserDetailsService , loadUserByName
    public int getUserId() {
      org.springframework.security.core.userdetails.User  user = (org.springframework.security.core.userdetails.User )SecurityContextHolder.getContext().getAuthentication().getPrincipal();
       User loggedinUser = userMapper.getUserIdByName(user.getUsername());
       _logger.info("Logged in userid  = "+loggedinUser.getUserId());
      return loggedinUser.getUserId();
    }
    
}
package com.ved.ca.mytwitter.domain;

public class UserFollower {
  
  private int userId;
  private int followerId;
  
  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public int getFollowerId() {
    return followerId;
  }

  public void setFollowerId(int followerId) {
    this.followerId = followerId;
  }

}

package com.ved.ca.mytwitter.mappers;

import com.ved.ca.mytwitter.domain.Message;
import com.ved.ca.mytwitter.domain.User;
import com.ved.ca.mytwitter.domain.UserFollower;
import org.apache.ibatis.annotations.Param;
import java.util.Collection;

public interface UserMapper {

	void createUser(User user);

	Collection<User>  findFollowers(@Param("userid") int userid);

	Collection<User>  findUsersFollowing(@Param("followerid") int followerid);

	void addFollower(@Param("userid") int userid, @Param("followerid") int followerid);

	Collection<Message> findMessagesNoSearch(@Param("userid") int userid);

	Collection<Message> findMessages(@Param("userid") int userid, @Param("keyword") String keyword);

	void deleteFollower(@Param("userid") int userid, @Param("followerid") int followerid);

	Collection<UserFollower> getPopularUserWithFollowers();

	User getUserIdByName(@Param("username") String username);

}
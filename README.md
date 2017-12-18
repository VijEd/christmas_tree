# christmas_tree
MiniTwitterApplication_SpringBoot

Title: Mini Twitter Coding Challenge

Application developed using Spring Boot, Spring Security, in memory database 'h2', and persistence framework 'mybatis'.

Schema and Initial data has been loaded at application startup using resources/shema.sql, resources/data.sql.

h2 console is accessed using http://localhost:8080/h2. 

HttpBasic Authentication is implemented with JDBCAuthentication. 

Application is accessed using the users 'jack'/'jack' or 'peter/peter' as exists in Users table.

Following are Http End Points to execute in postman


1. Endpoints to get the list of followers of th user.
Request Method : GET http://localhost:8080/user/followers/

2. Endpoints to get the list of people the user is following.
Request Method : GEThttp://localhost:8080/user/followees/

3.  An endpoint to start following another user. 
Request Method : POST http://localhost:8080/user/add/{followerid}

4.An endpoint to unfollow another user. 
  Request Method : DELETE http://localhost:8080/user/unfollow/{followerid}

5. An endpoint to read the message list for given user  Include messages they have sent and messages sent by users they     follow. Support a “search=” parameter that can be used to further filter messages based on keyword.
 Request Method : GET http://localhost:8080/messages?search=test

6.An endpoint that returns a list ofall users, paired with their most "popular" follower. The more followers someone has, the more "popular" they are. Hint: this is possible to do with a single SQL query!
Request Method : GET http://localhost:8080/user/popularUserInfo

Note - Every end point requires Basic Authentication. {followerid} is added as foreign key for userid in User table.

Sample endpoint executions with initial data
1. http://localhost:8080/user/followers - Login as jack  
  Returns three records Peter,name,name4
2. http://localhost:8080/user/followers - Login as jack
   Return twon records name5,name6
3. http://localhost:8080/user/add/4 - Login as peter 
4. http://localhost:8080/user/followers - Login as peter. Should see 'name4' user
5. http://localhost:8080/user/unfollow/4 - Login as 'peter'
6. http://localhost:8080/user/followers - Login as peter. Should get empty response as the user with userid=4 and name='name4' added in step4 is deleted.
7. http://localhost:8080/messages?search=test - Show 4 messages

    



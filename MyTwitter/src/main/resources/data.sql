

INSERT INTO users(userid,username,password,enabled,emailid) VALUES (1,'jack','jack', true, 'oneuser.gmail.com');

INSERT INTO users(userid,username,password,enabled,emailid) VALUES (2,'peter','peter', true, 'twouser.gmail.com');

INSERT INTO users(userid,username,password,enabled,emailid) VALUES (3,'name3','name3', true, 'threeuser.gmail.com');

INSERT INTO users(userid,username,password,enabled,emailid) VALUES (4,'name4','name4', true, 'fouruser.gmail.com');

INSERT INTO users(userid,username,password,enabled,emailid) VALUES (5,'name5','name5', true, 'fiveuser.gmail.com');

INSERT INTO users(userid,username,password,enabled,emailid) VALUES (6,'name6','name6', true, 'sixuser.gmail.com');

 

INSERT INTO user_roles (username, role) VALUES ('jack', 'ROLE_USER');

INSERT INTO user_roles (username, role) VALUES ('jack', 'ROLE_ADMIN');

INSERT INTO user_roles (username, role) VALUES ('peter', 'ROLE_USER');



insert into follow_relation (userid, followerid) VALUES (1,2);

insert into follow_relation (userid, followerid) VALUES (1,3);

insert into follow_relation (userid, followerid) VALUES (1,4);

insert into follow_relation (userid, followerid) VALUES (5,1);

insert into follow_relation (userid, followerid) VALUES (6,1);





 insert into messages (userid, content,timestamp) values (1,  'testmessagebyuser1',   GETDATE());

 insert into messages (userid, content,timestamp) values (5,  'testmessagebyuser5',   GETDATE());

 insert into messages (userid, content,timestamp) values (6,  'testmessagebyuser6',   GETDATE());

 insert into messages (userid, content,timestamp) values (2,  'testmessagebyuser2',   GETDATE());

 insert into messages (userid, content,timestamp) values (3,  'testmessagebyuser3',   GETDATE());


 insert into messages (userid, content,timestamp) values (4,  'testmessagebyuser4',   GETDATE());


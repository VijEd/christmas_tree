

DROP SCHEMA IF exists test_schema;



CREATE SCHEMA test_schema AUTHORIZATION sa; 



SET SCHEMA test_schema;



CREATE SEQUENCE SEQ_ID

START WITH 1

INCREMENT BY 1; 



CREATE TABLE users(

   userid integer not null,

   username varchar(20) NOT NULL,

   password varchar(20) NOT NULL,

   enabled boolean NOT NULL DEFAULT FALSE,

   emailid varchar(40) NOT NULL,

   primary key(userid)

);



CREATE TABLE follow_relation(

   seqid integer not null DEFAULT (NEXT VALUE FOR SEQ_ID), 

   userid integer not null ,

   followerid  integer not null,

   FOREIGN KEY (userid) REFERENCES users (userid),

   FOREIGN KEY (followerid) REFERENCES users (userid),

   primary key(userid, followerid)

);





create table user_roles (

  user_role_id SERIAL PRIMARY KEY,

  username varchar(20) NOT NULL,

  role varchar(20) NOT NULL,

  UNIQUE (username,role),

  FOREIGN KEY (username) REFERENCES users (username)

);



CREATE SEQUENCE MSG_SEQ_ID

START WITH 1

INCREMENT BY 1; 



CREATE TABLE messages(

   messageid integer not null DEFAULT (NEXT VALUE FOR SEQ_ID), 

   userid integer not null ,

   content varchar(256) NOT NULL,

   timestamp  datetime ,

   primary key(messageid),

   FOREIGN KEY (userid) REFERENCES users (userid)


);


DROP DATABASE IF EXISTS wechat;
CREATE DATABASE wechat DEFAULT CHARACTER SET utf8;
USE wechat;
/*
private String userId;
private String userName;
private String password;
private String avatarUrl;
private List<UserInfo> friendList;
private List<GroupInfo> groupList;
 */
CREATE TABLE user (
  userId int(11),
  userName varchar(255) ,
  password varchar(255),
  avatarUrl varchar(255)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

INSERT INTO user VALUES (1,'Azhu','123','Azhu');
INSERT INTO user VALUES (2,'Left-Behind','123','left-Behind');
INSERT INTO user VALUES (3,'张三','123','zs');
INSERT INTO user VALUES (4,'李四','123','ls');
INSERT INTO user VALUES (5,'史塔克','123','stack');

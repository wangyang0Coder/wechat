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
/*
private String groupId;
private String groupName;
private String groupAvatarUrl;
private List<UserInfo> members;
GROUP是数据库关键字不能用
 */
CREATE TABLE GROUP_ (
  groupId int(11),
  groupName varchar(255),
  groupAvatarUrl varchar(255)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;

INSERT INTO GROUP_ VALUES (1,'葬爱家族','非主流');
INSERT INTO GROUP_ VALUES (2,'帝国の','Japen');
INSERT INTO GROUP_ VALUES (3,'少林寺','达摩老祖');

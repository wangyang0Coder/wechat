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
  userId int NOT NULL AUTO_INCREMENT,
  userName varchar(255),
  password varchar(255),
  avatarUrl varchar(255),
  PRIMARY KEY (userId)
) ENGINE=InnoDB AUTO_INCREMENT=84 DEFAULT CHARSET=utf8;
/*AUTO_INCREMENT=84主键从哪里开始递增*/
INSERT INTO user VALUES (1,'Azhu','123','Azhu');
INSERT INTO user VALUES (2,'Left-Behind','123','left-Behind');
INSERT INTO user VALUES (3,'张三','123','zs');
INSERT INTO user VALUES (4,'李四','123','ls');
INSERT INTO user VALUES (5,'史塔克','123','stack');
insert into user (userName,password,avatarUrl) VALUES ('Test','123','test');
insert into user (userId,userName,password,avatarUrl) VALUES (84,'Test','123','test');
/*
private String groupId;
private String groupName;
private String groupAvatarUrl;
private List<UserInfo> members;
GROUP是数据库关键字不能用
 */
CREATE TABLE GROUP_ (
  groupId int(11) NOT NULL AUTO_INCREMENT,
  groupName varchar(255),
  groupAvatarUrl varchar(255),
  PRIMARY KEY (groupId)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO GROUP_ VALUES (1,'葬爱家族','非主流');
INSERT INTO GROUP_ VALUES (2,'帝国の','Japen');
INSERT INTO GROUP_ VALUES (3,'少林寺','达摩老祖');
insert into GROUP_ (groupName,groupAvatarUrl) VALUES ('Test','test');

CREATE TABLE  belong(
  id int(11) NOT NULL AUTO_INCREMENT,
  userId int(11),
  groupId int(11),
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO belong VALUES (1,1,1);
INSERT INTO belong VALUES (2,2,1);
INSERT INTO belong VALUES (3,4,2);
INSERT INTO belong VALUES (4,3,2);
INSERT INTO belong VALUES (5,1,3);
INSERT INTO belong VALUES (6,2,3);
INSERT INTO belong VALUES (7,3,3);
INSERT INTO belong VALUES (8,4,3);
INSERT INTO belong VALUES (9,5,3);
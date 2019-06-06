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
  email varchar(255),
  PRIMARY KEY (userId)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
/*AUTO_INCREMENT=1主键从哪里开始递增*/
INSERT INTO user VALUES (1,'Azhu','123','static/img/avatar/Azhu.jpg','2576419596@qq.com');
INSERT INTO user VALUES (2,'Left-','123','static/img/avatar/Left-.jpg','2576419596@qq.com');
INSERT INTO user VALUES (3,'张三','123','static/img/avatar/张三.jpg','2576419596@qq.com');
INSERT INTO user VALUES (4,'李四','123','static/img/avatar/李四.jpg','2576419596@qq.com');
INSERT INTO user VALUES (5,'史塔克','123','static/img/avatar/史塔克.jpg','2576419596@qq.com');
/*
private String groupId;
private String groupName;
private String groupAvatarUrl;
private List<UserInfo> members;
GROUP是数据库关键字不能用
 */
CREATE TABLE group_ (
  groupId int(11) NOT NULL AUTO_INCREMENT,
  groupName varchar(255),
  groupAvatarUrl varchar(255),
  PRIMARY KEY (groupId)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

INSERT INTO group_ VALUES (1,'葬爱家族','static/img/avatar/葬爱家族.jpg');
INSERT INTO group_ VALUES (2,'帝国の','static/img/avatar/帝国の.jpg');
INSERT INTO group_ VALUES (3,'少林寺','static/img/avatar/少林寺.jpg');
insert into group_ (groupName,groupAvatarUrl) VALUES ('Test','test');

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

CREATE TABLE  contact(
  id int(11) NOT NULL AUTO_INCREMENT,
  userId1 int(11),
  userId2 int(11),
  PRIMARY KEY(id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
INSERT INTO contact VALUES (1,1,2);
INSERT INTO contact VALUES (2,1,3);
INSERT INTO contact VALUES (3,1,4);
INSERT INTO contact VALUES (4,1,5);
INSERT INTO contact VALUES (5,2,3);
INSERT INTO contact VALUES (6,2,4);
INSERT INTO contact VALUES (7,4,3);
INSERT INTO contact VALUES (8,5,3);
INSERT INTO contact VALUES (9,4,5);

INSERT INTO contact VALUES (10,2,1);
INSERT INTO contact VALUES (11,3,1);
INSERT INTO contact VALUES (12,4,1);
INSERT INTO contact VALUES (13,5,1);
INSERT INTO contact VALUES (14,3,2);
INSERT INTO contact VALUES (15,4,2);
INSERT INTO contact VALUES (16,3,4);
INSERT INTO contact VALUES (17,3,5);
INSERT INTO contact VALUES (18,5,4);

/**消息表
    private int id;
    private String fromUserId;
    private String toUserId;
    private String toGroupId;
    private String content;
    private String type;
    private String fileUrl;
    private String originalFilename;
    private String fileSize;
 */
CREATE TABLE message (
  id int NOT NULL AUTO_INCREMENT,
  fromUserId int,
  toUserId int,
  toGroupId int,
  content varchar(255),
  type varchar(255),
  fileUrl varchar(255),
  originalFilename varchar(255),
  fileSize varchar(255),
  PRIMARY KEY (Id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
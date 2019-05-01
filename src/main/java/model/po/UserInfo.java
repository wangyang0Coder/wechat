package model.po;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 11:52
 * Description:用户类记录每个人的信息
 */
public class UserInfo {

    private String userId;
    private String userName;
    private String password;
    private String avatarUrl;
    private List<UserInfo> friendList;
    private List<GroupInfo> groupList;

    public UserInfo(String userId, String userName, String password, String avatarUrl) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAvatarUrl() {
        return avatarUrl;
    }

    public void setAvatarUrl(String avatarUrl) {
        this.avatarUrl = avatarUrl;
    }

    public List<UserInfo> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<UserInfo> friendList) {
        this.friendList = friendList;
    }

    public List<GroupInfo> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<GroupInfo> groupList) {
        this.groupList = groupList;
    }
}

package model.po;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 11:52
 * Description:用户类记录每个人的信息
 */
public class UserInfo {

    private Integer userId;
    private String userName;
    private String password;
    private String avatarUrl;
    private String email;
    private List<Contact> friendList;
    private List<Belong> groupList;
    private List<MessageInfo> messageList;


    public UserInfo() {
    }

    public List<MessageInfo> getMessageList() {
        return messageList;
    }

    public void setMessageList(List<MessageInfo> messageList) {
        this.messageList = messageList;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /*public UserInfo(int userId, String userName, String password, String avatarUrl) {
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.avatarUrl = avatarUrl;
    }*/

    public UserInfo(String username, String password, String avatarShow, String mail) {
        this.userName = username;
        this.password = password;
        this.avatarUrl = avatarShow;
        this.email=mail;
    }

    public UserInfo(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public UserInfo(String username, String password, String avatarShow) {
        this.userName = username;
        this.password = password;
        this.avatarUrl = avatarShow;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
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

    public List<Contact> getFriendList() {
        return friendList;
    }

    public void setFriendList(List<Contact> friendList) {
        this.friendList = friendList;
    }

    public List<Belong> getGroupList() {
        return groupList;
    }

    public void setGroupList(List<Belong> groupList) {
        this.groupList = groupList;
    }

    @Override
    public String toString() {
        return this.userId+" "+this.userName;
    }
    public String totoString(){
        return this.userId+"\n"
                +this.userName+"\n"
                +this.avatarUrl+"\n"
                +this.email+"\n";
    }
}

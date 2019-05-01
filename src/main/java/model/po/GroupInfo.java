package model.po;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 11:52
 * Description:这是一个群组类,一个群组里的人通讯应该是互通的
 */
public class GroupInfo {

    private String groupId;
    private String groupName;
    private String groupAvatarUrl;
    private List<UserInfo> members;

    public GroupInfo(String groupId, String groupName, String groupAvatarUrl, List<UserInfo> members) {
        this.groupId = groupId;
        this.groupName = groupName;
        this.groupAvatarUrl = groupAvatarUrl;
        this.members = members;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public String getGroupAvatarUrl() {
        return groupAvatarUrl;
    }

    public void setGroupAvatarUrl(String groupAvatarUrl) {
        this.groupAvatarUrl = groupAvatarUrl;
    }

    public List<UserInfo> getMembers() {
        return members;
    }

    public void setMembers(List<UserInfo> members) {
        this.members = members;
    }
}

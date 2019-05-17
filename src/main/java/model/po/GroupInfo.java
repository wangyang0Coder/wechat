package model.po;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 11:52
 * Description:这是一个群组类,一个群组里的人通讯应该是互通的
 */
public class GroupInfo {

    private long groupId;
    private String groupName;
    private String groupAvatarUrl;
    private List<Belong> members;
    public GroupInfo() {

    }

    public long getGroupId() {
        return groupId;
    }

    public void setGroupId(long groupId) {
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

    public List<Belong> getMembers() {
        return members;
    }

    public void setMembers(List<Belong> members) {
        this.members = members;
    }

    @Override
    public String toString() {
        return this.groupId + " " + this.groupName + " " + this.groupAvatarUrl;
    }
}

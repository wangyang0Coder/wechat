package model.po;

/**
 * @Author: Azhu
 * @Date: 2019/5/2 12:03
 * Description:描述用户与群组之间的关系
 */
public class Belong {
    private long id;
    private GroupInfo groupInfo;
    private UserInfo userInfo;

    public Belong() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public GroupInfo getGroupInfo() {
        return groupInfo;
    }

    public void setGroupInfo(GroupInfo groupInfo) {
        this.groupInfo = groupInfo;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}

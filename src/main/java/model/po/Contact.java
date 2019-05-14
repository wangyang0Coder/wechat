package model.po;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;

/**
 * @Author: Azhu
 * @Date: 2019/5/13 18:38
 * Description:用户之间的关系类
 */
public class Contact {
    private UserInfo userInfo1;
    private UserInfo userInfo2;

    public Contact() {
    }

    public UserInfo getUserInfo1() {
        return userInfo1;
    }

    public void setUserInfo1(UserInfo userInfo1) {
        this.userInfo1 = userInfo1;
    }

    public UserInfo getUserInfo2() {
        return userInfo2;
    }

    public void setUserInfo2(UserInfo userInfo2) {
        this.userInfo2 = userInfo2;
    }
}

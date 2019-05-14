package Test;

import com.sun.tools.internal.xjc.reader.xmlschema.bindinfo.BIConversion;
import model.mapper.UserInfoMapper;
import model.po.Contact;
import model.po.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:37
 * Description:
 */
public class TestMyBatis_userInfo {
    private static Logger logger = LoggerFactory.getLogger(TestMyBatis_userInfo.class.getName());
    @Test
    public void Test_insert(){
        UserInfo user=new UserInfo();
        user.setUserName("龙傲天");
        user.setPassword("123");
        user.setAvatarUrl("小龙");
        SqlSession session= MyBatisUtil.getSesssion();
        UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
        userInfoMapper.insert(user);
        Test_ListAll();
    }
    @Test
    public void Test_delete(){
        SqlSession session= MyBatisUtil.getSesssion();
        UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
        userInfoMapper.delete(6);
        Test_ListAll();
    }
    @Test
    public void Test_get(){
        SqlSession session= MyBatisUtil.getSesssion();
        UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
        UserInfo user=userInfoMapper.get(1);
        System.out.println(user);
    }
    @Test
    public void Test_update(){
        SqlSession session= MyBatisUtil.getSesssion();
        UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
        UserInfo user = userInfoMapper.get(5);
        user.setUserName("史塔克");
        user.setAvatarUrl("static/img/avatar/史塔克.jpg");
        userInfoMapper.update(user);
        Test_ListAll();
    }
    @Test
    public void Test_ListAll(){
        SqlSession session= MyBatisUtil.getSesssion();
        UserInfoMapper userInfoMapper=session.getMapper(UserInfoMapper.class);
        List<UserInfo> list=userInfoMapper.listAll();
        for(UserInfo c:list)
        {
            System.out.println(c.toString());
        }
    }

    @Test
    public void Test_getByUserId() {
        SqlSession session = MyBatisUtil.getSesssion();
        UserInfoMapper userInfoMapper = session.getMapper(UserInfoMapper.class);
        UserInfo userInfo = userInfoMapper.getByUserId(1L);
        List<Contact> userInfos = userInfo.getFriendList();
        for (Contact c : userInfos) {
            logger.info(userInfo.getUserName() + ":-----:" + c.getUserInfo2().getUserName());
        }

    }

}

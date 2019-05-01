package Test;

import model.mapper.UserInfoMapper;
import model.po.UserInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:37
 * Description:
 */
public class TestMyBatis_userInfo {

    @Test
    public void Test_insert(){
        UserInfo user=new UserInfo();
        user.setUserId(6);
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
        UserInfo user=new UserInfo();
        user.setUserId(2);
        user.setUserName("GGboy");
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


}

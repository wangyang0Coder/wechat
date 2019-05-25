package Test;

import model.mapper.GroupInfoMapper;
import model.mapper.UserInfoMapper;

import model.po.GroupInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:37
 * Description:
 */
public class TestMyBatis_groupInfo {

    @Test
    public void Test_insert(){
        GroupInfo user=new GroupInfo();
        user.setGroupId(6);
        user.setGroupName("武当");
        user.setGroupAvatarUrl("123");
        SqlSession session= MyBatisUtil.getSesssion();
        GroupInfoMapper groupInfoMapper=session.getMapper(GroupInfoMapper.class);
        groupInfoMapper.insert(user);
        Test_ListAll();
    }
    @Test
    public void Test_delete(){
        SqlSession session= MyBatisUtil.getSesssion();
        GroupInfoMapper groupInfoMapper=session.getMapper(GroupInfoMapper.class);
        groupInfoMapper.delete(6);
        Test_ListAll();
    }
    @Test
    public void Test_get(){
        SqlSession session= MyBatisUtil.getSesssion();
        GroupInfoMapper groupInfoMapper=session.getMapper(GroupInfoMapper.class);
        GroupInfo groupInfo=groupInfoMapper.getByGroupId(1);
        System.out.println(groupInfo.getMessageList().get(0));
    }
    @Test
    public void Test_update(){
        SqlSession session= MyBatisUtil.getSesssion();
        GroupInfoMapper groupInfoMapper=session.getMapper(GroupInfoMapper.class);
        GroupInfo groupInfo=new GroupInfo();
        groupInfo.setGroupId(2);
        groupInfo.setGroupName("帝国の");
        groupInfo.setGroupAvatarUrl("static/img/avatar/帝国の.jpg");
        groupInfoMapper.update(groupInfo);
        Test_ListAll();
    }
    @Test
    public void Test_ListAll(){
        SqlSession session= MyBatisUtil.getSesssion();
        GroupInfoMapper groupInfoMapper=session.getMapper(GroupInfoMapper.class);
        List<GroupInfo> list=groupInfoMapper.listAll();
        for(GroupInfo c:list)
        {
            System.out.println(c.toString());
        }
    }


}

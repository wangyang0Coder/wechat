package Test;

import model.mapper.BelongMapper;
import model.mapper.GroupInfoMapper;
import model.po.*;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/2 12:22
 * Description:
 */
public class TestMyBatis_group_user {
    @Test
    public void ListGroup(){
        SqlSession session= MyBatisUtil.getSesssion();
        GroupInfoMapper mapper=session.getMapper(GroupInfoMapper.class);
        List<GroupInfo> list=mapper.listAll();
        for(GroupInfo groupInfo:list){
            System.out.println(groupInfo.toString());
            List<Belong> list1=groupInfo.getMembers();
            if(null!=list1){
                for(Belong belong:list1){
                    System.out.format("\t%s\t%s%n",belong.toString(),belong.getUserInfo().getUserName());
                }
            }
        }
    }
    @Test
    public void Test11(){
        SqlSession session= MyBatisUtil.getSesssion();
        BelongMapper mapper=session.getMapper(BelongMapper.class);
        List<Belong> list =mapper.listByGroupId(1);
        for(Belong belong:list)
        {
            System.out.println(belong.getUserInfo().toString());
        }
    }
}

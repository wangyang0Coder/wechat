package Test;

import model.mapper.*;
import model.po.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import util.MyBatisUtil;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/2 12:22
 * Description:
 */
public class TestMyBatis_group_user {
    private static Logger logger = LogManager.getLogger(TestMyBatis_group_user.class.getName());
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
                    System.out.format("\t%s\t%s\t%s%n",belong.toString(),belong.getUserInfo().getUserName(),belong.getGroupInfo().getGroupName());
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
            logger.info("开始输出");
            System.out.println(belong.getUserInfo().toString());
            System.out.println("归属于："+belong.getGroupInfo().toString()+"群组");
            logger.info("结束输出");
        }
    }
}

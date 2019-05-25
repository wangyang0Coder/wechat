package Test;

import model.mapper.MessageInfoMapper;
import model.po.MessageInfo;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.MyBatisUtil;

import java.util.List;


/**
 * @Author: Azhu
 * @Date: 2019/5/25 10:08
 * Description:
 */
public class TestMyBatis_Message {

    private static Logger logger= LoggerFactory.getLogger(TestMyBatis_Message.class);
    /*
    case "SINGLE_SENDING"://单体消息发送
    case "GROUP_SENDING"://群组消息发送
    case "FILE_MSG_SINGLE_SENDING"://单体文件发送
    case "FILE_MSG_GROUP_SENDING"://群组文件发送
    */
    @Test
    public void insert(){
        SqlSession session= MyBatisUtil.getSesssion();
        MessageInfoMapper mapper=session.getMapper(MessageInfoMapper.class);
        MessageInfo messageInfo=new MessageInfo();
        messageInfo.setFromUserId(1);
        messageInfo.setToGroupId(1);
        messageInfo.setContent("大家好");
        messageInfo.setType("GROUP_SENDING");
        mapper.insert(messageInfo);
    }
    @Test
    public void listByUserId(){
        SqlSession session= MyBatisUtil.getSesssion();
        MessageInfoMapper mapper=session.getMapper(MessageInfoMapper.class);
        List<MessageInfo> list=mapper.listByUserId(1);
        for (MessageInfo message:list) {
               logger.info(message.toString());
        }
    }
    @Test
    public void listByGroupId(){
        SqlSession session= MyBatisUtil.getSesssion();
        MessageInfoMapper mapper=session.getMapper(MessageInfoMapper.class);
        List<MessageInfo> list=mapper.listByGroupId(1);
        for (MessageInfo message:list) {
            logger.info(message.toString());
        }
    }
}

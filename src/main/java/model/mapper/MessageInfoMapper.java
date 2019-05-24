package model.mapper;

import model.po.Contact;
import model.po.MessageInfo;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/24 13:53
 * Description:
 */
public interface MessageInfoMapper {


    @Select("select * from message where fromUserId=#{id} or toUserId=#{id}")
    public List<MessageInfo> listByUserId(int id);
    @Select("select * from message where toGroupId=#{id}")
    public List<MessageInfo> listByGroupId(int id);
}

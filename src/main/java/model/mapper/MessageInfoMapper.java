package model.mapper;

import model.po.Contact;
import model.po.MessageInfo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/24 13:53
 * Description:
 */
public interface MessageInfoMapper {

    @Insert("insert into message (fromUserId,toUserId,toGroupId,content,type,fileUrl,originalFilename,fileSize) values(#{fromUserId,jdbcType=INTEGER },#{toUserId,jdbcType=INTEGER},#{toGroupId,jdbcType=INTEGER},#{content,jdbcType=VARCHAR},#{type,jdbcType=VARCHAR},#{fileUrl,jdbcType=VARCHAR},#{originalFilename,jdbcType=VARCHAR},#{fileSize,jdbcType=VARCHAR})")
    public void insert(MessageInfo messageInfo);

    @Select("select * from message where fromUserId=#{id} and toUserId!=0 or toUserId=#{id} and fromUserId!=0")
    public List<MessageInfo> listByUserId(Integer id);//保证筛选到的都是SINGLE_SENDING

    @Select("select * from message where toGroupId=#{id}")
    public List<MessageInfo> listByGroupId(Integer id);


}

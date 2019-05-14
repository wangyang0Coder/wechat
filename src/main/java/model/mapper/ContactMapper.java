package model.mapper;

import model.po.Belong;
import model.po.Contact;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/13 18:44
 * Description:
 */
public interface ContactMapper {
    @Select("select * from Contact where userId1=#{id} or userId2=#{id}")
    @Results({
            @Result(property = "userInfo1", column = "userId1", one = @One(select = "model.mapper.UserInfoMapper.get")),
            //column是执行one = @One(select = "model.mapper.UserInfoMapper.get"))的传入
            @Result(property = "userInfo2", column = "userId2", one = @One(select = "model.mapper.UserInfoMapper.get"))
    })
    public List<Contact> listAll(int id);
}

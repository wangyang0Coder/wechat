package model.mapper;

import model.po.Belong;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Results;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/2 12:06
 * Description:
 */
public interface BelongMapper {
    @Select("select * from belong where groupid=#{groupid}")
    @Results({
            @Result(property = "userInfo",column = "userId",one = @One(select = "model.mapper.UserInfoMapper.get")),
            //column是执行one = @One(select = "model.mapper.UserInfoMapper.get"))的传入
            @Result(property = "groupInfo",column = "groupId",one = @One(select = "model.mapper.GroupInfoMapper.get"))
    })
    public List<Belong> listByGroupId(int groupid);
}

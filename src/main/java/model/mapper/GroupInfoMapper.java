package model.mapper;

import model.po.GroupInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/2 10:23
 * Description:
 */
public interface GroupInfoMapper {
    @Insert("insert into group_ (groupId,groupName,groupAvatarUrl) values (#{groupId},#{groupName},#{groupAvatarUrl})")
    void insert(GroupInfo groupInfo);

    @Update("update group_ set groupName=#{groupName},groupAvatarUrl=#{groupAvatarUrl}  where groupId=#{groupId}")
    void update(GroupInfo groupInfo);

    @Delete("delete from group_ where groupId= #{id}")
    void delete(long id);

    @Select("select * from group_ where  groupId=#{id}")
    GroupInfo get(long id);

    @Select("select * from group_")
        @Results({
                @Result(property = "groupId",column = "groupId"),
                @Result(property = "members",javaType =List.class,column ="groupId",
                        many =@Many(select = "model.mapper.BelongMapper.listByGroupId"))
        })
    List<GroupInfo> listAll();

    @Select("select * from group_ where groupId = #{id}")
    @Results({
            @Result(property = "groupId", column = "groupId"),
            @Result(property = "members", javaType = List.class, column = "groupId",
                    many = @Many(select = "model.mapper.BelongMapper.listByGroupId"))
    })
    GroupInfo getByGroupId(long id);
}

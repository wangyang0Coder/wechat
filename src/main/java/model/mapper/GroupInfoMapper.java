package model.mapper;

import model.po.GroupInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/2 10:23
 * Description:
 */
public interface GroupInfoMapper {
    @Insert("insert into group_ (groupId,groupName,groupAvatarUrl) values (#{groupId},#{groupName},#{groupAvatarUrl})")
    void insert(GroupInfo groupInfo);

    @Update("update group_ set groupName=#{groupName} where groupId=#{groupId}")
    void update(GroupInfo groupInfo);

    @Delete("delete from group_ where groupId= #{id}")
    void delete(long id);

    @Select("select * from group_ where  groupId=#{id}")
    GroupInfo get(long id);

    @Select("select * from group_")
    List<GroupInfo> listAll();
}

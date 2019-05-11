package model.mapper;

import model.po.UserInfo;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

/**
 * @Author: Azhu
 * @Date: 2019/5/1 17:43
 * Description:
 */
public interface UserInfoMapper {

    @Insert("insert into user (userId,userName,password,avatarUrl) values (#{userId},#{userName},#{password},#{avatarUrl})")
    void insert(UserInfo userInfo);

    @Update("update user set userName=#{userName} where userId=#{userId}")
    void update(UserInfo userInfo);

    @Delete("delete from user where userId= #{id}")
    void delete(long id);

    @Select("select * from user where userId=#{id}")
    UserInfo get(long id);

    @Select("select * from user")
    List<UserInfo> listAll();

    @Select("select * from user where userName=#{username}")
    UserInfo getByUsername(String username);
}
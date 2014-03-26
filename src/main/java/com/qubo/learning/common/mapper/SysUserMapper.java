package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysUser;
import org.apache.ibatis.annotations.*;

import java.util.List;


/**
 * Created by Qubo_Song on 2/27/14.
 */
public interface SysUserMapper {

    @Select("select * from sys_user where user_name=#{username}")
    public SysUser getUserByName(@Param("username")String username);

    @Select("select * from sys_user where user_id=#{userId}")
    public SysUser getUserById(@Param("userId")int userId);

    @Select("select * from sys_user")
    public List<SysUser> getAllUsers();

    @Update("update sys_user set online = #{online} where user_name = #{username}")
    public void setUserOnlineStatusByName(@Param("username")String username, @Param("online")boolean online);

    @Select("select count(user_id) from sys_user where online = #{online}")
    public int getUserCountByStatus(@Param("online")boolean online);

    @Insert("insert into sys_user values(default, #{username}, #{password}, #{enabled}, #{online})")
    public void addUser(@Param("username")String username, @Param("password")String password, @Param("enabled")boolean enabled, @Param("online")boolean online);

    @Update("update sys_user set enabled = #{isEnabled} where user_id = #{user_id}")
    public void setUserEnabledStatusById(@Param("user_id") int user_id, @Param("isEnabled") boolean isEnabled);
}

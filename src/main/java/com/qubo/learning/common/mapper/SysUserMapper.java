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

    @Select("select * from sys_user")
    public List<SysUser> getAllUsers();

    @Update("update sys_user set online = #{online} where user_name = #{username}")
    public void setUserOnlineStatusByName(@Param("username")String username, @Param("online")boolean online);

    @Select("select count(user_id) from sys_user where online = #{online}")
    public int getUserCountByStatus(@Param("online")boolean online);
}

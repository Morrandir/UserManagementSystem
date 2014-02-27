package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysUser;
import org.apache.ibatis.annotations.*;


/**
 * Created by Qubo_Song on 2/27/14.
 */
public interface SysUserMapper {

    @Select("select * from sys_user where user_name=#{username}")
    @Results({
            @Result(property = "userID", column = "user_id"),
            @Result(property = "userName", column = "user_name"),
            @Result(property = "userPwd", column = "password"),
            @Result(property = "userEnabled", column = "enabled"),
            @Result(property = "userRoleID", column = "role_id")
    })
    public SysUser getUserByName(String username);

}

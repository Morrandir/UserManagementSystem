package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysUserRole;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Qubo_Song on 2/27/14.
 */
public interface SysUserRoleMapper {

    @Select("select * from sys_user_role where user_id=#{userId}")
    public List<SysUserRole> getUserRolesByUserID(@Param("userId")int userId);

    @Insert("insert into sys_user_role values(default, #{userId}, #{roleName})")
    public void addRole(@Param("userId")int userId, @Param("roleName")String roleName);
}

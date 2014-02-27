package com.qubo.learning.common.mapper;

import com.qubo.learning.common.model.SysUserRole;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Created by Qubo_Song on 2/27/14.
 */
public interface SysUserRoleMapper {

    @Select("select * from sys_user_role where user_id=#{id}")
    public List<SysUserRole> getUserRoleByUserID(int id);

}

package com.qubo.learning.common.service;

import com.qubo.learning.common.model.ROLE;
import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.model.SysUserRole;

import java.util.List;

/**
 * Created by Qubo_Song on 2/27/14.
 */
public interface UserDao {

    public SysUser getUserByName(String username);

    public SysUser getUserById(int id);

    public List<SysUser> getAllUsers();

    public void setUserOnlineByName(String username);

    public void setUserOfflineByName(String username);

    public int getOnlineUserCount();

    public void addUser(String userName, String password, ROLE userRole) throws Exception;

    public List<ROLE> getUserRolesByUserID(int userId);

}

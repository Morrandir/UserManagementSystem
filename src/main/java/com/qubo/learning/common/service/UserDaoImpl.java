package com.qubo.learning.common.service;

import com.qubo.learning.common.mapper.SysUserMapper;
import com.qubo.learning.common.mapper.SysUserRoleMapper;
import com.qubo.learning.common.model.ROLE;
import com.qubo.learning.common.model.SysUser;
import com.qubo.learning.common.model.SysUserRole;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by Qubo_Song on 2/27/14.
 */
@Repository("userDao")
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao, UserDetailsService {

    @Autowired
    private SysUserMapper userMapper;

    @Autowired
    private SysUserRoleMapper userRoleMapper;

    private static AtomicLong userId;
    private static AtomicLong roleId;

    @PostConstruct
    public void init() {
        userId = new AtomicLong(userMapper.getMaxUserId());
        roleId = new AtomicLong(userRoleMapper.getMaxRoleId());
        userId.getAndIncrement();
        roleId.getAndIncrement();
    }


    @Autowired
    @Override
    public void setSqlSessionFactory(org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public SysUser getUserByName(String username) {
        return userMapper.getUserByName(username);
    }

    @Override
    public List<SysUserRole> getUserRolesByUserID(int id) {
        return userRoleMapper.getUserRolesByUserID(id);
    }

    @Override
    public List<SysUser> getAllUsers() {
        return userMapper.getAllUsers();
    }

    @Override
    public void setUserOnlineByName(String username) {
        userMapper.setUserOnlineStatusByName(username, true);
    }

    @Override
    public void setUserOfflineByName(String username) {
        userMapper.setUserOnlineStatusByName(username, false);
    }

    @Override
    public int getOnlineUserCount() {
        return userMapper.getUserCountByStatus(true);
    }

    @Override
    public void addUser(String userName, String password, String userRole) {

        ROLE role = ROLE.valueOf(userRole);

        userMapper.addUser((int)userId.get(), userName, password, true, false);


        for(int i = 0; i <= role.getIndex(); i++) {
            userRoleMapper.addRole((int)roleId.get(), (int)userId.get(), ROLE.values()[i].toString());
            roleId.getAndIncrement();
        }
        userId.getAndIncrement();



    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser;
        List<SysUserRole> sysUserRoles;
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();


        sysUser = getUserByName(username);
        if(sysUser == null) {
            throw new UsernameNotFoundException("User \"" + username + "\" not found!");
        }

        sysUserRoles = getUserRolesByUserID(sysUser.getUser_id());

        for (SysUserRole x : sysUserRoles) {
            authList.add(new SimpleGrantedAuthority(x.getRole_name()));
        }

        return (new User(sysUser.getUser_name(), sysUser.getPassword(), sysUser.isEnabled(), true, true, true, authList));
    }


}

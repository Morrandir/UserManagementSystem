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
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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
    public SysUser getUserById(int id) {
        return userMapper.getUserById(id);
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
    @Transactional
    public void addUser(String userName, String password, ROLE userRole) throws Exception {

        SysUser user;

        try {
            userMapper.addUser(userName, password, true, false);
            user = userMapper.getUserByName(userName);

            if (user != null) {
                for(int i = 0; i <= userRole.getIndex(); i++) {
                    userRoleMapper.addRole(user.getUser_id(), ROLE.values()[i].toString());
                }
            }

            //throw new RuntimeException();
        } catch(Exception e) {
            throw e;
        }

    }

    @Override
    public List<ROLE> getUserRolesByUserID(int userId) {
        List<SysUserRole> sysUserRoles;
        List<ROLE> userRoles = new ArrayList<ROLE>();
        sysUserRoles = userRoleMapper.getUserRolesByUserID(userId);

        for(SysUserRole sysUserRole : sysUserRoles) {
            switch(ROLE.valueOf(sysUserRole.getRole_name())) {
                case ROLE_ADMIN:
                    userRoles.add(ROLE.ROLE_ADMIN);
                    break;
                case ROLE_USER:
                    userRoles.add(ROLE.ROLE_USER);
                    break;

            }
        }

        return userRoles;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUser sysUser;
        List<ROLE> userRoles;
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();


        sysUser = getUserByName(username);
        if(sysUser == null) {
            throw new UsernameNotFoundException("User \"" + username + "\" not found!");
        }

        userRoles = getUserRolesByUserID(sysUser.getUser_id());

        for (ROLE userRole : userRoles) {
            authList.add(new SimpleGrantedAuthority(userRole.toString()));
        }

        return (new User(sysUser.getUser_name(), sysUser.getPassword(), sysUser.isEnabled(), true, true, true, authList));
    }


}

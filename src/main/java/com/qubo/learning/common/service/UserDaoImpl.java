package com.qubo.learning.common.service;

import com.qubo.learning.common.mapper.SysUserMapper;
import com.qubo.learning.common.mapper.SysUserRoleMapper;
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

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Qubo_Song on 2/27/14.
 */
@Repository
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
    public List<SysUserRole> getUserRoleByUserID(int id) {
        return userRoleMapper.getUserRoleByUserID(id);
    }

    @Override
    public List<SysUser> getAllUsers() {
        return userMapper.getAllUsers();
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

        sysUserRoles = getUserRoleByUserID(sysUser.getUser_id());

        for (int i = 0; i < sysUserRoles.size(); i++) {
            authList.add(new SimpleGrantedAuthority(sysUserRoles.get(i).getRole_name()));
        }


        UserDetails userDetails = new User(sysUser.getUser_name(), sysUser.getPassword(), sysUser.isEnabled(), true, true, true, authList);

        return userDetails;
    }


}

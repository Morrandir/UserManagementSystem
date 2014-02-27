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
    @Override
    public void setSqlSessionFactory(org.apache.ibatis.session.SqlSessionFactory sqlSessionFactory) {
        super.setSqlSessionFactory(sqlSessionFactory);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        SysUserMapper userMapper = getSqlSession().getMapper(SysUserMapper.class);
        SysUserRoleMapper userRoleMapper = getSqlSession().getMapper(SysUserRoleMapper.class);
        SysUser sysUser;
        List<SysUserRole> sysUserRoles;
        List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();


        sysUser = userMapper.getUserByName(username);
        if(sysUser == null) {
            throw new UsernameNotFoundException("User \"" + username + "\" not found!");
        }

        sysUserRoles = userRoleMapper.getUserRoleByUserID(sysUser.getUserID());

        for (int i = 0; i < sysUserRoles.size(); i++) {
            authList.add(new SimpleGrantedAuthority(sysUserRoles.get(i).getRole_name()));
        }


        UserDetails userDetails = new User(sysUser.getUserName(), sysUser.getUserPwd(), sysUser.isUserEnabled(), true, true, true, authList);

        return userDetails;
    }


}

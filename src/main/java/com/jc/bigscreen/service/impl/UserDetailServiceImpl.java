package com.jc.bigscreen.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.jc.bigscreen.dao.RolesDao;
import com.jc.bigscreen.dao.UserrolesDao;
import com.jc.bigscreen.dao.UsersDao;
import com.jc.bigscreen.entity.Roles;
import com.jc.bigscreen.entity.Userroles;
import com.jc.bigscreen.entity.Users;
import com.jc.bigscreen.utils.MyUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDetailServiceImpl implements UserDetailsService {
    @Autowired
    UsersDao usersDao;

    @Autowired
    UserrolesDao userrolesDao;

    @Autowired
    RolesDao rolesDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名从数据库中查询数据信息
        QueryWrapper<Users> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",username);
        Users user = usersDao.queryByUsername(username);
        //查询不到该用户信息抛异常
        if(user==null){
            throw new RuntimeException("用户名或者密码错误");
        }
        List<Userroles> userroles = userrolesDao.queryByUserId(user.getUserId());
        ArrayList<Roles> roles = new ArrayList<>();
        for (Userroles userrole : userroles) {
            Integer roleId = userrole.getRoleId();
            Roles role = rolesDao.queryById(roleId);
            roles.add(role);
        }
        user.setRoles(roles);
        // 将数据库中的角色转为 GrantedAuthority
        List<GrantedAuthority> authorities = user.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRoleName()))
                .collect(Collectors.toList());
        //封装成UserDetails返回
        return new MyUser(user);
    }

}
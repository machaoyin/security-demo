package com.mcy.securitydemo;

import com.mcy.securitydemo.entity.SysRole;
import com.mcy.securitydemo.entity.SysUser;
import com.mcy.securitydemo.service.RoleService;
import com.mcy.securitydemo.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class SecurityDemoApplicationTests {

    @Autowired
    private RoleService roleService;
    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
       /* SysRole role = new SysRole();
        role.setName("ROLE_USER");
        roleService.save(role);
        SysRole role1 = new SysRole();
        role1.setName("ROLE_ADMIN");
        roleService.save(role1);
        SysRole role2 = new SysRole();
        role2.setName("ROLE_DBA");
        roleService.save(role2);

        SysUser user = new SysUser();
        user.setName("张三");
        //用于对密码加密
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        user.setPassword(encoder.encode("123456"));
        user.setUsername("123456");
        List<SysRole> roles = new ArrayList<>();
        roles.add(role);    //给123456用户添加ROLE_USER权限
        user.setRoles(roles);
        userService.save(user);

        SysUser user1 = new SysUser();
        user1.setName("李四");
        //用于对密码加密
        user1.setPassword(encoder.encode("123456"));
        user1.setUsername("system");
        List<SysRole> roles1 = new ArrayList<>();
        roles1.add(role1);    //给system用户添加ROLE_USER权限
        roles1.add(role2);
        user1.setRoles(roles1);
        userService.save(user1);*/
    }

}

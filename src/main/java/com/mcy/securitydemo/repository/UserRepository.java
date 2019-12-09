package com.mcy.securitydemo.repository;

import com.mcy.securitydemo.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<SysUser, Integer> {
    //根据登录用户名查询用户
    SysUser findByUsername(String username);
}

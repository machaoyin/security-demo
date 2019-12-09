package com.mcy.securitydemo.repository;

import com.mcy.securitydemo.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SysRole, Integer> {

}

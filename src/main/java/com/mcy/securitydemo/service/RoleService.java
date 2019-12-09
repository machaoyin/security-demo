package com.mcy.securitydemo.service;

import com.mcy.securitydemo.entity.SysRole;
import com.mcy.securitydemo.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public void save(SysRole role) {
        roleRepository.save(role);
    }
}

package com.mcy.securitydemo.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sys_user")
public class SysUser {
    private Integer id;
    private String name;
    private String username;
    private String password;
    private List<SysRole> roles;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @ManyToMany(cascade=CascadeType.REFRESH,fetch=FetchType.EAGER)
    @JoinTable(name="sys_user_role",joinColumns=@JoinColumn(name="user_id"),inverseJoinColumns=@JoinColumn(name="role_id"))
    public List<SysRole> getRoles() {
        return roles;
    }

    public void setRoles(List<SysRole> roles) {
        this.roles = roles;
    }
}

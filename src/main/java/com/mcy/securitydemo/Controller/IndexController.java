package com.mcy.securitydemo.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {
    @RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
    public String index(){
        return "login";
    }

    @RequestMapping("/home")
    public String homePage(ModelMap map){
        map.put("user", getUsername());
        map.put("role", getAuthority());
        return "home";
    }

    @RequestMapping("/admin")
    public String admin(ModelMap map){
        map.put("user", getUsername());
        map.put("role", getAuthority());
        return "admin";
    }

    @RequestMapping("/dba")
    public String dba(ModelMap map){
        map.put("user", getUsername());
        map.put("role", getAuthority());
        return "dba";
    }

    @RequestMapping("/accessDenied")
    public String accessDenied(ModelMap map){
        map.put("user", getUsername());
        map.put("role", getAuthority());
        return "accessDenied";
    }

    /**
     * 获取当前用户名称
     * @return
     */
    private String getUsername(){
        //获取当前用户名称
        String username = SecurityContextHolder.getContext().getAuthentication().getName();
        System.out.println("username="+username);
        return username;
    }

    private String getAuthority(){
        //获得Authentication对象，表示用户认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        List<String> roles = new ArrayList<>();
        //将角色名称添加到List集合
        for(GrantedAuthority a: authentication.getAuthorities()){
            roles.add(a.getAuthority());
        }
        System.out.println("role="+roles);
        return roles.toString();
    }
}

package com.mcy.securitydemo.security;

import javax.servlet.Servlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import java.io.IOException;
import java.util.Set;

public class LoginSuccessHandle  implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication)throws IOException {
        //authentication.getAuthorities() 获取当前用户的权限
        Set<String> roles = AuthorityUtils.authorityListToSet(authentication.getAuthorities());

        //获取到登陆者的权限，然后做跳转
        if (roles.contains("ROLE_ADMIN")){
            response.sendRedirect("/admin");
            return;
        }else if (roles.contains("ROLE_USER")){
            response.sendRedirect("/home");
            return;
        }else {
            response.sendRedirect("/accessDenied");
        }
    }
}
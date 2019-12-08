package com.mcy.securitydemo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 用户认证操作
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("WebSecurityConfig   configure(AuthenticationManagerBuilder auth) 方法被调用。。。。。。");
        //添加用户，并给予权限
        auth.inMemoryAuthentication().withUser("aaa").password("{noop}1234").roles("USER");
        auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").roles("ADMIN", "DBA");
    }

    /**
     * 用户授权操作
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("WebSecurityConfig   configure(HttpSecurity http) 方法被调用。。。。。。");
        http.csrf().disable();    //安全器令牌
        http.authorizeRequests()    //开始请求权限配置。
                .antMatchers("/login", "/static/**").permitAll()
                .antMatchers("/", "/home").hasRole("USER")
                .antMatchers("/admin/**").hasAnyRole("ADMIN", "DBA")
                .anyRequest().authenticated()   //其余所有的请求都需要认证（用户登录）之后才可以访问。
                .and()
                .formLogin()    //开始设置登录操作
                .loginPage("/login")   //设置登录页面的访问地址
                //.defaultSuccessUrl("/main")  //指定登录成功后转向的页面。
                .successHandler(new LoginSuccessHandle())    //登录成功跳转，LoginSuccessHandle处理不同权限跳转不同页面
                .failureUrl("/login?error")    //指定登录失败后转向的页面和传递的参数。
                .and()
                .logout().permitAll()       //退出
                .and()
                .exceptionHandling().accessDeniedPage("/accessDenied"); //指定异常处理页面
    }
}

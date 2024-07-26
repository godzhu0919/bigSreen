package com.jc.bigscreen.config;

import com.jc.bigscreen.Filter.JwtAuthenticationTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private JwtAuthenticationTokenFilter jwtAuthenticationTokenFilter;

    @Bean
    PasswordEncoder password(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable() // 禁用 CSRF 保护
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) // 不使用 session
                .and()
                .authorizeRequests()
                .antMatchers("/swagger-ui.html","/dirverInfo/**", "/webjars/**", "/v2/**", "/swagger-resources/**")
                .permitAll()
                    .antMatchers("/user/login").permitAll() // 登录接口允许所有人访问
//                    .antMatchers("/dirverInfo/**").hasRole("ADMIN") // admin 开头的 URL 需要 ADMIN 角色
                    .antMatchers("/user/**").hasAnyRole("USER", "ADMIN") // user 开头的 URL 需要 USER 或 ADMIN 角色
                .anyRequest().authenticated() // 除上面外的所有请求全部需要鉴权认证
                .and();
//                .formLogin()
//                .loginPage("/login") // 登录页面的路径
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
                http.cors();
                http.addFilterBefore(jwtAuthenticationTokenFilter, UsernamePasswordAuthenticationFilter.class);
    }



}
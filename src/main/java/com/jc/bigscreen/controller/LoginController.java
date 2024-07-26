package com.jc.bigscreen.controller;

import com.jc.bigscreen.entity.Users;
import com.jc.bigscreen.utils.JwtUtil;
import com.jc.bigscreen.utils.MyUser;
import com.jc.bigscreen.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

@RestController
@Api(tags="登录控制器")
public class LoginController {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    AuthenticationManager authenticationManager;



    @PostMapping("/user/login")
    @ApiOperation(value = "登录接口")
    public Result login(@RequestBody Users tbUser){
        //通过AuthenticationManager的authenticate方法来进行用户认证
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=new UsernamePasswordAuthenticationToken(tbUser.getUsername(),tbUser.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);
        if(authenticate==null){
            return Result.error("401","登录校验失败");
        }
        else {
            //获取用户信息
            MyUser myUser = (MyUser) authenticate.getPrincipal();
            //获取用户id
            Integer userId = myUser.getUser().getUserId();
            //根据用户id生成token
            String token = JwtUtil.generateToken(String.valueOf(userId));
            //将token放在数据库中
            redisTemplate.opsForValue().set(String.valueOf(userId),myUser,30, TimeUnit.MINUTES);
            return Result.success(token);
        }

    }
}

package com.lzx.gateway.controller;

import com.lzx.gateway.dto.ReturnData;
import com.lzx.gateway.dto.UserDTO;
import com.lzx.gateway.jwt.JwtModel;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.web.bind.annotation.*;

/**
 * 描述: 认证接口
 *
 * @Auther: lzx
 * @Date: 2019/7/9 13:53
 */
@RestController
@Slf4j
@RequestMapping("/auth")
public class AuthController {

    /**
     * 登陆认证接口
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public ReturnData<String> login(@RequestBody UserDTO userDTO){
        UsernamePasswordToken usernamePasswordToken = new UsernamePasswordToken(userDTO.getUserName(), userDTO.getPassword());
        Subject subject = SecurityUtils.getSubject();
        try{
            subject.login(usernamePasswordToken);
        }catch (AuthenticationException e){
            return new ReturnData<String>(HttpStatus.SC_UNAUTHORIZED,"认证失败",null);
        }
        JwtModel jwtModel = (JwtModel) subject.getPrincipal();
        //TODO 获取jwt Token

        return new ReturnData<String>(HttpStatus.SC_OK,"123456",null);
    }

    /**
     * 为授权提示
     */
    @GetMapping("/unauthorized")
    public ReturnData<String> unauthorized(){
        return new ReturnData<String> (HttpStatus.SC_UNAUTHORIZED,"未认证,请重新登陆",null);
    }

}

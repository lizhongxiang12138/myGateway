package com.lzx.gateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzx.gateway.annotation.JwtCheck;
import com.lzx.gateway.dto.ReturnData;
import com.lzx.gateway.dto.UserDTO;
import com.lzx.gateway.jwt.JwtModel;
import com.lzx.gateway.jwt.JwtUtil;
import jdk.nashorn.internal.objects.annotations.Getter;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;

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

    private ObjectMapper objectMapper;

    @Value("${org.my.jwt.effective-time}")
    private String effectiveTime;

    public AuthController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    /**
     * 登陆认证接口
     * @param userDTO
     * @return
     */
    @PostMapping("/login")
    public ReturnData<String> login(@RequestBody UserDTO userDTO) throws Exception {
        ArrayList<String> roleIdList = new ArrayList<>(1);
        roleIdList.add("role_test_1");
        JwtModel jwtModel = new JwtModel("test", roleIdList);
        int effectivTimeInt = Integer.valueOf(effectiveTime.substring(0,effectiveTime.length()-1));
        String effectivTimeUnit = effectiveTime.substring(effectiveTime.length()-1,effectiveTime.length());
        String jwt = null;
        switch (effectivTimeUnit){
            case "s" :{
                //秒
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 1000L);
                break;
            }
            case "m" :{
                //分钟
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 60L * 1000L);
                break;
            }
            case "h" :{
                //小时
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 60L * 60L * 1000L);
                break;
            }
            case "d" :{
                //小时
                jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), effectivTimeInt * 24L * 60L * 60L * 1000L);
                break;
            }
        }
        return new ReturnData<String>(HttpStatus.SC_OK,"认证成功",jwt);
    }

    /**
     * 为授权提示
     */
    @GetMapping("/unauthorized")
    public ReturnData<String> unauthorized(){
        return new ReturnData<String> (HttpStatus.SC_UNAUTHORIZED,"未认证,请重新登陆",null);
    }

    /**
     * jwt 检查注解测试 测试
     * @return
     */
    @GetMapping("/testJwtCheck")
    @JwtCheck
    public ReturnData<String> testJwtCheck(@RequestHeader("Authorization")String token,@RequestParam("name")@Valid String name){

        return new ReturnData<String>(HttpStatus.SC_OK,"请求成功咯","请求成功咯"+name);

    }
}

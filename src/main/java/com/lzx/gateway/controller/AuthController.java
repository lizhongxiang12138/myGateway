package com.lzx.gateway.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lzx.gateway.dto.ReturnData;
import com.lzx.gateway.dto.UserDTO;
import com.lzx.gateway.jwt.JwtModel;
import com.lzx.gateway.jwt.JwtUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
        String jwt = JwtUtil.createJWT("test", "test", objectMapper.writeValueAsString(jwtModel), 1L * 24L * 60L * 60L * 1000L);
        return new ReturnData<String>(HttpStatus.SC_OK,"认证成功",jwt);
    }

    /**
     * 为授权提示
     */
    @GetMapping("/unauthorized")
    public ReturnData<String> unauthorized(){
        return new ReturnData<String> (HttpStatus.SC_UNAUTHORIZED,"未认证,请重新登陆",null);
    }

}

package com.lzx.gateway.jwt;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * 描述:jwt 模型
 *
 * @Auther: lzx
 * @Date: 2019/7/9 13:42
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class JwtModel {

    private String userName;

    private List<String> roleIdList;

}

package com.lzx.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 描述: 用户DTO
 *
 * @Auther: lzx
 * @Date: 2019/7/9 13:57
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserDTO {

    private String userName;

    private String password;

}

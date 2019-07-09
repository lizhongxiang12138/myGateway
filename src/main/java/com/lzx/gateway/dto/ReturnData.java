package com.lzx.gateway.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 描述:
 *
 * @Auther: lzx
 * @Date: 2019/7/9 13:55
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ReturnData<T> {

    private int code;

    private String mass;

    private T data;

}

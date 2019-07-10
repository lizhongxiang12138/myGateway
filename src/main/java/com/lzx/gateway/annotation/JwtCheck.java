package com.lzx.gateway.annotation;

import java.lang.annotation.*;

/**
 * 描述: jwt检查注解
 *
 * @Auther: lzx
 * @Date: 2019/6/17 16:24
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JwtCheck {

    String value() default "";
}

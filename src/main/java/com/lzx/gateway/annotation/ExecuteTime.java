package com.lzx.gateway.annotation;

import java.lang.annotation.*;

/**
 * 描述: 记录调用时间
 *
 *  lzx
 *  2019/2/11 09:57
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ExecuteTime {

    String value() default "";
}

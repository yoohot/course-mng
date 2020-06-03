package com.tencent.course.model.base;/**
 * @Author cgl
 * @Date 2020/6/2 18:07
 */

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author cgl
 * @date 2020/6/2 18:07
 */
@AllArgsConstructor
@Getter
public enum RetCode {

    SUCCESS(0,"success"),
    SYS_ERROR(5000,"system error")
    ;
    private int code;
    private String msg;
}

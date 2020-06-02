package com.tencent.course.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @Author cgl
 * @Date 2020/6/2 16:21
 */
@AllArgsConstructor
@Getter
public enum CoursePriceType {

    /**
     * 免费课程
     */
    FREE(0),
    /**
     * 付费课程
     */
    PAY(1);

    private int type;
}

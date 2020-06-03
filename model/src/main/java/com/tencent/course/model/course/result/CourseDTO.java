package com.tencent.course.model.course.result;/**
 * @Author cgl
 * @Date 2020/6/2 20:04
 */

import lombok.Data;

import java.math.BigDecimal;

/**
 * @author cgl
 * @date 2020/6/2 20:04
 */
@Data
public class CourseDTO {


    private Long id;

    private String originalId;

    private String title;

    /**
     * 主图地址
     */
    private String pictUrl;

    /**
     * 课程地址
     */
    private String courseUrl;

    /**
     * 讲师名称
     */
    private String teacherName;

    /**
     * 课程数
     */
    private String chapterNum;

    private BigDecimal realPrice;

    private Integer priceType;

    /**
     * 原价
     */
    private BigDecimal price;

    /**
     * 首页展示日期
     */
    private String openDate;

    private String categoryName;

    private String resource;

}

package com.tencent.course.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * <p>
 * 课程记录表
 * </p>
 *
 * @author cgl
 * @since 2020-06-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@ToString
public class CourseRecord implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(type = IdType.AUTO)
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
    private LocalDate openDate;

    private String categoryName;

    private String resource;


    private LocalDateTime gmtCreated;

    private LocalDateTime gmtModified;


}

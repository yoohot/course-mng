package com.course.model.course.param;/**
 * @Author cgl
 * @Date 2020/6/2 20:03
 */

import lombok.Data;

/**
 * @author cgl
 * @date 2020/6/2 20:03
 */
@Data
public class CourseListParam {

    private int pageSize=10;
    private int pageNumber=1;

    private String title;
}

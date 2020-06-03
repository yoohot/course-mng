package com.tencent.course.service;

import com.course.model.base.PageData;
import com.course.model.course.param.CourseListParam;
import com.course.model.course.result.CourseDTO;

/**
 * @Author cgl
 * @Date 2020/6/2 20:05
 */
public interface CourseService {

    /**
     * 首页课程列表
     */
    PageData<CourseDTO> courseList(CourseListParam param);
}

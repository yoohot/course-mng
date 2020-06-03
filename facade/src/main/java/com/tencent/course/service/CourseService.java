package com.tencent.course.service;


import com.tencent.course.model.base.PageData;
import com.tencent.course.model.course.param.CourseListParam;
import com.tencent.course.model.course.result.CourseDTO;

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

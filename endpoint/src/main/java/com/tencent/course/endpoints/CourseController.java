package com.tencent.course.endpoints;/**
 * @Author cgl
 * @Date 2020/6/2 19:48
 */

import com.course.model.base.PageData;
import com.course.model.course.param.CourseListParam;
import com.course.model.course.result.CourseDTO;
import com.tencent.course.manager.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cgl
 * @date 2020/6/2 19:48
 */
@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping("/list")
    public  PageData<CourseDTO> list(  CourseListParam param) {
        return courseService.courseList(param);
    }
}

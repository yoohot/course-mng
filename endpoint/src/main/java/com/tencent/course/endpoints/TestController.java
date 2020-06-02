package com.tencent.course.endpoints;

import com.course.model.base.Result;
import com.tencent.course.service.CrawlCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author cgl
 * @date 2020/6/2 18:02
 */
@RestController()
@RequestMapping("/test")
@Profile(value = {"dev","default"})
public class TestController {

    @Autowired
    private CrawlCourseService crawlCourseService;

    @GetMapping("/crawl")
    public Result crawl() {
        crawlCourseService.crawl();
        return Result.success();
    }

    @RequestMapping("/health")
    public Result health(){
        return Result.success();
    }
}

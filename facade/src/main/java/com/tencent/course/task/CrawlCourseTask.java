package com.tencent.course.task;/**
 * @Author cgl
 * @Date 2020/6/2 21:25
 */

import com.tencent.course.context.CrawlCourseFactory;
import com.tencent.course.model.CourseResourceEnum;
import com.tencent.course.service.CrawlCourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author cgl
 * @date 2020/6/2 21:25
 */
@Service
@Slf4j
public class CrawlCourseTask {

    @Autowired
    private CrawlCourseService crawlCourseService;

    @Scheduled(cron = "0 0 5 * * ?")
    @Async("asyncTaskPool")
    public void asyncCrawlQQCourseTask() {
        //Redis.lock()
        log.info("start crawl qq course data...");
        CrawlCourseService crawlCourseService = CrawlCourseFactory.getCrawlCourseService(CourseResourceEnum.QQ);
        crawlCourseService.crawl();
        log.info(" crawl qq course data end...");
    }
}

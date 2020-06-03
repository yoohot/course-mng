package com.tencent.course.context;/**
 * @Author cgl
 * @Date 2020/6/2 21:28
 */

import com.tencent.course.model.CourseResourceEnum;
import com.tencent.course.service.CrawlCourseService;
import com.tencent.course.service.impl.CrawlQQCourseServiceImpl;
import org.springframework.beans.factory.SmartInitializingSingleton;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author cgl
 * @date 2020/6/2 21:28
 */
@Service
public class CrawlCourseFactory implements SmartInitializingSingleton {

    @Autowired
    private List<CrawlCourseService> crawlCourseServiceList;

    private static Map<CourseResourceEnum, CrawlCourseService> crawlMap = new HashMap<>();

    public static CrawlCourseService getCrawlCourseService(CourseResourceEnum resource) {
        return crawlMap.get(resource);
    }


    @Override
    public void afterSingletonsInstantiated() {
        crawlCourseServiceList.forEach(service -> {
            if (service instanceof CrawlQQCourseServiceImpl) {
                crawlMap.putIfAbsent(CourseResourceEnum.QQ, service);
            }
            //其他
        });


    }
}

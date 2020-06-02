package com.tencent.course.config;/**
 * @Author cgl
 * @Date 2020/6/2 15:35
 */

/**
 * @author cgl
 * @date 2020/6/2 15:35
 */

import org.apache.commons.lang3.concurrent.BasicThreadFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author cgl
 * @date 2020/6/2 15:11
 */
@Configuration
@EnableConfigurationProperties(QQHtmlProperties.class)
public class CoreConfig {

    @Bean("asyncTaskPool")
    public ThreadPoolExecutor asnycTaskThreadPoolExecutor() {
        BasicThreadFactory.Builder builder = new BasicThreadFactory.Builder();
        builder.namingPattern("asyncTask");
        ThreadPoolExecutor pool = new ThreadPoolExecutor(1, 5, 60L, TimeUnit.SECONDS, new SynchronousQueue<>(), builder.build(), new ThreadPoolExecutor.AbortPolicy());
        return pool;
    }
}

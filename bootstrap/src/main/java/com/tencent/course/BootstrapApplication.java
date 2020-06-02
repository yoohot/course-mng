package com.tencent.course;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

/**
 * @author cgl
 * @date 2020/6/2 11:57
 */
@SpringBootApplication
@EnableAsync
@EnableScheduling
@Slf4j
public class BootstrapApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootstrapApplication.class, args);
        log.info("bootstrap started ... activeProfile:"+ Arrays.toString(context.getEnvironment().getActiveProfiles()));
    }
}

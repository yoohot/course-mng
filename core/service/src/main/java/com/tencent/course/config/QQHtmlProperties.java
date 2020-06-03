package com.tencent.course.config;/**
 * @Author cgl
 * @Date 2020/6/2 15:26
 */

import lombok.Data;
import lombok.ToString;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 首页标签的class name动态配置，这里给的默认值，页面修改后可以更改配置文件
 *
 * @author cgl
 * @date 2020/6/2 15:26
 */
@Data
@ToString
@ConfigurationProperties(prefix = "crawl.html")
public class QQHtmlProperties {

    private String crawlUrl = "https://ke.qq.com/";

    //"container"
    private String courseContainerClassName = "container";

    //custom-course-wrap
    private String courseCategoryClassName = "custom-course-wrap";

    //course-card-list
    private String courseCardListClassName = "course-card-list";

    //js-course-card-item
    private String courseCardItemClassName = "js-course-card-item";

    //item-img-link
    private String courseCardItemImgClassName = "item-img-link";

    //item-tt-link
    private String courseCardItemTitleClassName = "item-tt-link";

    //item-task
    private String courseCardItemTaskClassName = "item-task";

    //item-source-link
    private String courseCardItemTeacherClassName = "item-source-link";

    //item-price
    private String courseCardItemPriceClassName = "item-price";

    //item-price--origin
    private String courseCardItemPriceOriginClassName = "item-price--origin";

}

package com.tencent.course.crawl;/**
 * @Author cgl
 * @Date 2020/6/2 14:00
 */

import com.alibaba.fastjson.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;

/**
 * @author cgl
 * @date 2020/6/2 14:00
 */
public class CrawlerTest {


    @Test
    public void testCrawl0() throws IOException {

        Elements elements = Jsoup.connect("https://ke.qq.com").get().children();
        Elements cards = elements.toggleClass("course-card-item--v3 js-course-card-item");
        cards.forEach(card -> {
            System.out.println(card.html());
            System.out.println("----------------");
            System.out.println(JSONObject.toJSONString(card.getElementsByTag("a")));
        });
    }



}

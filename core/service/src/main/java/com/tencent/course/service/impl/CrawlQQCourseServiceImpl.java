package com.tencent.course.service.impl;/**
 * @Author cgl
 * @Date 2020/6/2 13:52
 */

import com.tencent.course.config.QQHtmlProperties;
import com.tencent.course.entity.CourseRecord;
import com.tencent.course.model.CoursePriceType;
import com.tencent.course.model.CourseResourceEnum;
import com.tencent.course.service.CrawlCourseService;
import com.tencent.course.service.ICourseRecordService;
import lombok.extern.slf4j.Slf4j;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 爬取qq课堂首页课程
 *
 * @author cgl
 * @date 2020/6/2 13:52
 */
@Service
@Slf4j
public class CrawlQQCourseServiceImpl implements CrawlCourseService {
    @Autowired
    private ICourseRecordService courseRecordService;

    @Autowired
    private QQHtmlProperties qqHtmlProperties;


    @Override
    public void crawl() {
        try {
            List<CourseRecord> records = new ArrayList<>();
            Elements parent = Jsoup.connect(qqHtmlProperties.getCrawlUrl()).get().children();
            log.info(" filter class: container");
            parent.forEach(ele -> {
                Elements container = ele.getElementsByClass(qqHtmlProperties.getCourseContainerClassName());
                container.forEach(con -> {
                    Elements categories = con.getElementsByClass(qqHtmlProperties.getCourseCategoryClassName());
                    categories.forEach(element -> {
                        String categoryName = element.attr("data-name");
                        log.info("start parse   category:{}", categoryName);
                        Elements courseParent = element.getElementsByClass(qqHtmlProperties.getCourseCardListClassName());
                        courseParent.forEach(cr -> {
                            Elements courseItems = cr.getElementsByClass(qqHtmlProperties.getCourseCardItemClassName());
                            courseItems.forEach(item -> {
                                CourseRecord courseRecord = convertItemElementToCourseRecord(item);
                                if (courseRecord != null) {
                                    courseRecord.setCategoryName(categoryName);
                                    records.add(courseRecord);
                                }
                            });
                        });
                        log.info("parse category:{} success,parse item  final size:{}", categories, records.size());
                    });
                });
            });
            log.info(" generate records  size:{}",records.size());
            if(!CollectionUtils.isEmpty(records)){
                courseRecordService.saveBatch(records);
            }
            log.info("step4: save records to db success");
        } catch (IOException e) {
            //监控告警
            log.error("crawl qq course error", e);
        }
    }


    private CourseRecord convertItemElementToCourseRecord(Element element) {
        try {
            CourseRecord record = new CourseRecord();
            Elements aEle = element.getElementsByClass(qqHtmlProperties.getCourseCardItemImgClassName());
            //课程地址
            String courseUrl = aEle.attr("href");
            String originalId = aEle.attr("data-id");
            //主图
            StringBuilder pictUrBuilder = new StringBuilder();
            aEle.forEach(a -> {
                Elements img = a.getElementsByTag("img");
                if (img != null) {
                    pictUrBuilder.append(img.attr("src"));
                    return;
                }
            });
            String pictUrl = pictUrBuilder.toString();
            //title
            Elements titleEle = element.getElementsByClass(qqHtmlProperties.getCourseCardItemTitleClassName());
            String title = titleEle.attr("title");
            //课程相关
            //课程数: eg 供21节
            String courseNum = element.getElementsByClass(qqHtmlProperties.getCourseCardItemTaskClassName()).text();
            //课程教师
            String teacherName =  element.getElementsByClass(qqHtmlProperties.getCourseCardItemTeacherClassName()).attr("title");
            //价格相关
            String priceValue = element.getElementsByClass(qqHtmlProperties.getCourseCardItemPriceClassName()).text();
            if ("免费".equalsIgnoreCase(priceValue)) {
                record.setPriceType(CoursePriceType.FREE.getType());
            } else {
                record.setPriceType(CoursePriceType.PAY.getType());
                String realPrice = element.getElementsByClass(qqHtmlProperties.getCourseCardItemPriceClassName()).text().substring(1);
                String originPrice = element.getElementsByClass(qqHtmlProperties.getCourseCardItemPriceOriginClassName()).text().substring(1);
                record.setRealPrice(new BigDecimal(realPrice));
                record.setPrice(new BigDecimal(originPrice));
            }
            record.setChapterNum(courseNum);
            record.setCourseUrl(courseUrl);
            record.setGmtCreated(LocalDateTime.now());
            record.setGmtModified(LocalDateTime.now());
            record.setOpenDate(LocalDate.now());
            record.setPictUrl(pictUrl);
            record.setResource(CourseResourceEnum.QQ.name());
            record.setTeacherName(teacherName);
            record.setTitle(title);
            record.setOriginalId(originalId);
            return record;
        } catch (Exception e) {
            log.error("parse element error:{}", element.tag().getName(), e);
        }
        return null;

    }

    public static void main(String[] args) {
        CrawlCourseService crawlCourseService = new CrawlQQCourseServiceImpl();

        crawlCourseService.crawl();
    }


}

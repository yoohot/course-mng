package com.tencent.course.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tencent.course.entity.CourseRecord;
import com.tencent.course.manager.ICourseRecordManager;
import com.tencent.course.service.CourseService;
import com.tencent.course.model.base.PageData;
import com.tencent.course.model.course.param.CourseListParam;
import com.tencent.course.model.course.result.CourseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author cgl
 * @Date 2020/6/2 20:08
 */
@Service
public class CourseServiceImpl implements CourseService {

    @Autowired
    private ICourseRecordManager courseRecordService;

    /**
     * 首页课程列表
     *
     * @param param
     */
    @Override
    public PageData<CourseDTO> courseList(CourseListParam param) {
        Page page = new Page();
        page.setCurrent(param.getPageNumber());
        page.setSize(param.getPageSize());
        page.setSearchCount(true);
        QueryWrapper query = new QueryWrapper();
        if (!StringUtils.isEmpty(param.getTitle())) {
            query.like("title", param.getTitle());
        }
        courseRecordService.page(page, query);
        PageData<CourseDTO> data = new PageData();
        data.setTotal(page.getTotal());
        List<CourseRecord> records = page.getRecords();
        if (CollectionUtils.isEmpty(records)) {
            data.setRows(new ArrayList<>());
        } else {
            data.setRows(records.stream().map(this::convertCourseEntityToDTO).collect(Collectors.toList()));
        }
        return data;
    }

    private CourseDTO convertCourseEntityToDTO(CourseRecord r) {
        CourseDTO dto = new CourseDTO();
        dto.setId(r.getId());
        dto.setCategoryName(r.getCategoryName());
        dto.setChapterNum(r.getChapterNum());
        dto.setCourseUrl(r.getCourseUrl());
        dto.setOpenDate(r.getOpenDate().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        dto.setPictUrl(r.getPictUrl());
        dto.setOriginalId(r.getOriginalId());
        dto.setPrice(r.getPrice());
        dto.setPriceType(r.getPriceType());
        dto.setRealPrice(r.getRealPrice());
        dto.setResource(r.getResource());
        dto.setTeacherName(r.getTeacherName());
        dto.setTitle(r.getTitle());
        return dto;
    }
}

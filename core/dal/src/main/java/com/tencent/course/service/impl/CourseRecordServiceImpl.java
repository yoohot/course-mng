package com.tencent.course.service.impl;

import com.tencent.course.entity.CourseRecord;
import com.tencent.course.mapper.CourseRecordMapper;
import com.tencent.course.service.ICourseRecordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程记录表 服务实现类
 * </p>
 *
 * @author cgl
 * @since 2020-06-02
 */
@Service
public class CourseRecordServiceImpl extends ServiceImpl<CourseRecordMapper, CourseRecord> implements ICourseRecordService {

}

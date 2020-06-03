package com.tencent.course.model.base;/**
 * @Author cgl
 * @Date 2020/6/3 9:32
 */

import lombok.Data;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @author cgl
 * @date 2020/6/3 9:32
 */

@Data
@ToString
public class PageData<T> {

    // 实体类集合
    private List<T> rows = new ArrayList<T>();
    // 数据总条数
    private long total;
}

package com.course.model.base;/**
 * @Author cgl
 * @Date 2020/6/2 20:06
 */

import lombok.Data;

import java.util.List;

/**
 * @author cgl
 * @date 2020/6/2 20:06
 */
@Data
public class PageData<T> {

    private List<T> list;

    private long total;
    private int pageNo;
    private int pageSize;
}

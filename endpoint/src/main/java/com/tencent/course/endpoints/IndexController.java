package com.tencent.course.endpoints;/**
 * @Author cgl
 * @Date 2020/6/2 19:48
 */

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author cgl
 * @date 2020/6/2 19:48
 */
@Controller
public class IndexController {

    @RequestMapping(value = {"/","/index"})
    public String index(){

        return "list.html";
    }

}

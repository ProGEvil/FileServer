package com.filehelper.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @ClassName IndexController
 * @Description TODO
 * @Author prog_evil
 * @Date 2021/11/5 1:26 上午
 * @Version 1.0
 **/
@Controller
public class IndexController {

    @RequestMapping("/file")
    public String toIndex(){
        return "file";
    }
}

package com.example.controller

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dalaoyang
 * @Description
 * @project springboot_learn
 * @package com.dalaoyang.Controller
 * @email yangyang@dalaoyang.cn
 * @date 2018/4/9
 */
@Controller
public class IndexController {

    @RequestMapping("/upload")
    public String index()
    {
        System.out.println("&&&")
        return "upload";
    }
}
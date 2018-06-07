package com.mathias.usermanage.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/5/29
 */
@RestController
public class TestController {
    @RequestMapping("/test")
    public String userTest(String name){
        return "hello,"+name;
    }
}

package com.mathias.ui.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author ：mathias
 * Description:
 * Date: 2018/5/29
 */
@FeignClient(value ="user-manage")
public interface TestService {
    @RequestMapping("/test")
    String userTest(@RequestParam(value = "name") String name);
}

package com.chenhaibo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Auther: chenhaibo
 * @Date: 2018/12/6 15:46
 * @Description:
 */
@Slf4j
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index()  {
        log.info("==============IndexController==============index==============");
        return "forward:index.html";
    }
}

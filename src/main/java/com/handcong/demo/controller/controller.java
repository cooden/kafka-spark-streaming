package com.handcong.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class controller {
    @RequestMapping("/")
    public String index(){
        return "/index.html";
    }

    @RequestMapping("/realTime")
    public String echart(){
        return "/realTime.html";
    }

}

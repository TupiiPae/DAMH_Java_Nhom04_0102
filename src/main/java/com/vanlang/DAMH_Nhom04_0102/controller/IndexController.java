package com.vanlang.DAMH_Nhom04_0102.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {
    @GetMapping("/index")
    public String showIndex(Model model){
        return "/index";
    }
}

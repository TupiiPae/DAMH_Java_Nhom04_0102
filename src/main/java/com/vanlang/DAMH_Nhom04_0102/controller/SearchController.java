package com.vanlang.DAMH_Nhom04_0102.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SearchController {
    @GetMapping("/search")
    public String showSearch(Model model){
        return ("/search");
    }
}

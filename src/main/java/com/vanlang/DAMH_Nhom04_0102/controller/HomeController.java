package com.vanlang.DAMH_Nhom04_0102.controller;

import com.vanlang.DAMH_Nhom04_0102.model.Category;
import com.vanlang.DAMH_Nhom04_0102.model.Product;
import com.vanlang.DAMH_Nhom04_0102.service.CategoryService;
import com.vanlang.DAMH_Nhom04_0102.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;// Đảm bảo bạn đã inject CategoryService
    // Display a list of all products
    @GetMapping("/home")
    public String showHome(Model model) {
        List<Product> products = productService.getAllProducts();
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        model.addAttribute("products", products);
        return "/product";
    }

}
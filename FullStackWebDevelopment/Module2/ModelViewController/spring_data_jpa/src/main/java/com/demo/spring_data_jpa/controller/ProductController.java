package com.demo.spring_data_jpa.controller;

import com.demo.spring_data_jpa.service.ProductService;
import com.demo.spring_data_jpa.service.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductService productService;

    // display list of products
    @GetMapping("/")
    public String viewHomePage(Model model){
        model.addAttribute("ListProducts", productService.getAllProducts());
        return "menu";
    }
}

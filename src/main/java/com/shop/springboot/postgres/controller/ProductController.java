package com.shop.springboot.postgres.controller;


import com.shop.springboot.postgres.model.Product;
import com.shop.springboot.postgres.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private ProductService service;


    @GetMapping("/shop")
    public String viewHomePage(Model model) {
        List<Product> listProduct = service.listAll();
        model.addAttribute("listProduct", listProduct);

        return "shop";
    }

}

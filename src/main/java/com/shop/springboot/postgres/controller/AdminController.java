package com.shop.springboot.postgres.controller;


import com.shop.springboot.postgres.model.Product;
import com.shop.springboot.postgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class AdminController {

    @Autowired
    private ProductService service;

    @GetMapping("/shop_admin")
    public String viewHomePage(Model model) {
        List<Product> listProduct = service.listAll();
        model.addAttribute("listProduct", listProduct);

        return "shop_admin";
    }

    @GetMapping("/shop_new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_product";
    }

    @PostMapping( "/shop_save")
    public String saveProduct(@ModelAttribute("product") Product product) {
        try {
            float priceCheck = product.getPrice();
            if ( !Float.isNaN(priceCheck) || product.getPrice() > 0 )
                service.save(product);
            return "redirect:/shop_admin";
        } catch ( Exception e ) {
            return "new_product";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_product");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/shop_admin";
    }
}

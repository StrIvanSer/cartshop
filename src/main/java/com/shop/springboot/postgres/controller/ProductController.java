package com.shop.springboot.postgres.controller;


import com.shop.springboot.postgres.model.Cart;
import com.shop.springboot.postgres.model.Product;
import com.shop.springboot.postgres.service.AutoService;

import com.shop.springboot.postgres.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProductController {

    @Autowired
    private AutoService service;


    @RequestMapping("/")
    public String viewHomePage(Model model) {
        List<Product> listProduct = service.listAll();
        model.addAttribute("listProduct", listProduct);

        return "index";
    }

    @RequestMapping("/new")
    public String showNewProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "new_auto";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveProduct(@ModelAttribute("product") Product product) {

        try {
            float priceCheck = product.getPrice();
            if ( !Float.isNaN(priceCheck) || product.getPrice() > 0 )
                service.save(product);
                return "redirect:/";
        } catch ( Exception e ) {
          return "new_auto";
        }
//        service.save(product);
//                return "redirect:/";


    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditProductPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("edit_auto");
        Product product = service.get(id);
        mav.addObject("product", product);

        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/";
    }
}

package com.shop.springboot.postgres.controller;


import com.shop.springboot.postgres.model.Cart;
import com.shop.springboot.postgres.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @RequestMapping("/cart")
    public String viewCart(Model model) {

        List<Cart> listCart = cartService.listAll();
        model.addAttribute("listCart", listCart);

        return "cart";
    }

    @RequestMapping(value = "/savecart", method = RequestMethod.POST)
    public String saveProductToCart(@RequestParam String product, @RequestParam Float price,
                                    @RequestParam Integer val, @ModelAttribute Cart cart) {

        float fullPriceProduct;
        fullPriceProduct = price * val;
        cart.setValue(val);
        cart.setSum(fullPriceProduct);
        cart.setProduct(product);
        cart.setEmail("svet@inbox.ru");
        cartService.save(cart);

        return "redirect:/";
    }

}

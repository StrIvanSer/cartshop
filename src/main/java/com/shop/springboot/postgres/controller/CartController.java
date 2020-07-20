package com.shop.springboot.postgres.controller;


import com.shop.springboot.postgres.model.Cart;
import com.shop.springboot.postgres.model.Product;
import com.shop.springboot.postgres.model.User;
import com.shop.springboot.postgres.service.CartService;
import com.shop.springboot.postgres.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class CartController {

    @Autowired
    private CartService cartService;

    @Autowired
    private ProductService productService;

//    @Autowired
//    private CartItemService cartItemService;

    @GetMapping("/cart")
    public String viewCart(Model model, @AuthenticationPrincipal User user) {

        Cart cart = cartService.getCartUser(user.getEmail());
        model.addAttribute("cart", cart);
        return "cart";
    }

    @PostMapping("/save-to-cart")
    public String saveProductToCart(@ModelAttribute("product") Product product,
                                    @RequestParam Integer val,
                                    @ModelAttribute Cart cart,
                                    @AuthenticationPrincipal User user) {

//        Cart cartFromShop = cartService.getCartUser(user.getEmail());
//        float fullPriceProduct;
//        fullPriceProduct = product.getPrice() * val;
//
//        float scale = (float) Math.pow(10, 3);
//        float result = (float) (Math.ceil(fullPriceProduct * scale) / scale);
//        product.getId();
//
//        cartFromShop.getProducts().add(product);
//
//        product.getCart().add(cartFromShop);
//
//        cartService.save(cartFromShop);

        return "redirect:/shop";
    }

    @GetMapping("/delete_cart/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id) {

        return "redirect:/shop";
    }

}

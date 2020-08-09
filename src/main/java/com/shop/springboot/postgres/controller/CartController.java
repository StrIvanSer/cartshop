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
        Float sum = (float) 0;
        Cart cart = cartService.getCartUser(user.getEmail());
        for (Product i: cart.getProducts() ){
            sum += i.getPrice();
        }
        model.addAttribute("cart", cart);
        model.addAttribute("sum", sum);
        return "cart";
    }

    @PostMapping("/save-to-cart")
    public String saveProductToCart(@ModelAttribute("product") Product product,
                                    @RequestParam Integer val,
                                    @ModelAttribute Cart cart,
                                    @AuthenticationPrincipal User user) {

        Cart cartFromShop = cartService.getCartUser(user.getEmail());

        cartService.saveProductCart(cartFromShop, product);

        return "redirect:/shop";
    }

    @PostMapping("/delete_cart/{id}")
    public String deleteProduct(@PathVariable(name = "id") int id,
                                @AuthenticationPrincipal User user)  {

        Product product = productService.get(id);
        Cart cart = cartService.getCartUser(user.getEmail());

        cartService.delete(cart,product);

        return "redirect:/cart";
    }

}

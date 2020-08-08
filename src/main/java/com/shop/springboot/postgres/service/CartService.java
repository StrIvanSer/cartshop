package com.shop.springboot.postgres.service;

import com.shop.springboot.postgres.model.Cart;
import com.shop.springboot.postgres.model.Product;
import com.shop.springboot.postgres.model.Role;
import com.shop.springboot.postgres.model.User;
import com.shop.springboot.postgres.repo.CartRepository;
import com.shop.springboot.postgres.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static java.util.Collections.*;


@Service
@Transactional
public class CartService {

    @Autowired
    ProductRepository productRepository;

    @Autowired
    ProductService productService;

    private final CartRepository cartRepo;


    public CartService(CartRepository cartRepo) {
        this.cartRepo = cartRepo;
    }


    public Cart getCartUser(String email) {

        return cartRepo.findByEmail(email);
    }


    //Сохранение корзины
    public void save(Cart cart) {
        cartRepo.save(cart);
    }

    public boolean getCart(String email) {
        return cartRepo.findByEmailAndActiveFalse(email);
    }

//    public Cart get(String email) {
//        return
//                cartRepo.findByEmail(email);
//    }

    public void delete(Cart cart, Product product) {
        cart.getProducts().remove(product);
//        cartRepo.deleteByProducts((List<Product>) product);
        product.getCart().remove(cart);
        productRepository.save(product);
        cartRepo.save(cart);

//         cartRepo.deleteByProducts((List<Product>) product);
    }

    public Cart getById(long id) {
        return  cartRepo.findById(id);
    }


    public boolean saveProductCart(Cart cart, Product product) {
//        Cart userFromDB = cartRepo.findByEmail(cart.getEmail());
//        if (userFromDB == null) {
//            return false;
//        }
        Product product1 = productService.get(product.getId());
//        userFromDB = cart;
        cart.getProducts().add(product1);
        product1.getCart().add(cart);
        productRepository.save(product1);
        cartRepo.save(cart);
        return true;
    }
}

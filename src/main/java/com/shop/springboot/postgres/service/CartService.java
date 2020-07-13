package com.shop.springboot.postgres.service;

import com.shop.springboot.postgres.model.Cart;
import com.shop.springboot.postgres.repo.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service
@Transactional
public class CartService {

    @Autowired
    private CartRepository cartRepo;

    public List<Cart> listAll() {

        return cartRepo.findAll();
    }

    public void save(Cart cart) {

        cartRepo.save(cart);
    }

    public Cart get(String email) {
        return
                cartRepo.findByEmail(email);
    }

    public void delete(long id) {

        cartRepo.deleteById(id);
    }
}

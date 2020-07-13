package com.shop.springboot.postgres.repo;

import com.shop.springboot.postgres.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CartRepository extends JpaRepository<Cart, Long> {

    Cart findByEmail(String email);

    }

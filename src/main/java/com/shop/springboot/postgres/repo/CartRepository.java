package com.shop.springboot.postgres.repo;

import com.shop.springboot.postgres.model.Cart;
import com.shop.springboot.postgres.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * Интерфейс для работы с JPA для сущности корзина
 * @author Streltsov Ivan
 * @version  1.0
 */

public interface CartRepository extends JpaRepository<Cart, Long> {
    //Поиск корзины по имейлу
    Cart findByEmail(String email);

    Cart findById(long id);

    //Поиск активной корзины
    boolean findByEmailAndActiveFalse(String email);

    void deleteByProducts(List<Product> products);

    }

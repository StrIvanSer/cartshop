package com.shop.springboot.postgres.repo;

import com.shop.springboot.postgres.model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для работы с JPA для сущности корзина
 * @author Streltsov Ivan
 * @version  1.0
 */

public interface CartRepository extends JpaRepository<Cart, Long> {
    //Поиск корзины по имейлу
    Cart findByEmail(String email);

    //Поиск активной корзины
    boolean findByEmailAndActiveFalse(String email);

    }

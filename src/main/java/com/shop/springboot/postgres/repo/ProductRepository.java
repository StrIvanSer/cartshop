package com.shop.springboot.postgres.repo;

import com.shop.springboot.postgres.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для работы с JPA для сущности товары
 * @author Streltsov Ivan
 * @version  1.0
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findById(long id);
}

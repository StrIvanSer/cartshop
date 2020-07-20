package com.shop.springboot.postgres.repo;

import com.shop.springboot.postgres.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Интерфейс для работы с JPA для сущности пользователи
 * @author Streltsov Ivan
 * @version  1.0
 */

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}

package com.shop.springboot.postgres.repo;

import com.shop.springboot.postgres.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;


/**
 * Интерфейс для работы с JPA для сущности статус юзера
 * @author Streltsov Ivan
 * @version  1.0
 */

public interface RoleRepository extends JpaRepository<Role,Long> {
}

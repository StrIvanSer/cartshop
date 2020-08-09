package com.shop.springboot.postgres.model;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Таблицы корзина
 * @author Streltsov Ivan
 * @version  1.0
 */



@Entity
@Getter
@Setter
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cart_id")
    private Long id;

    @Column
    @NotNull
    private String email;

    @Column
    @NotNull
    private Float sum;

    @ManyToMany(mappedBy = "cart")
    private List<Product> products;

    @Column
    @NotNull
    private boolean active ;


    public Cart() {

    }


}

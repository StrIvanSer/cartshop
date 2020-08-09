package com.shop.springboot.postgres.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Таблица товары
 * @author Streltsov Ivan
 * @version  1.0
 */

@Entity
@Getter
@Setter
@Table(name = "product")
public class Product {

    @Id
    @Column(name = "prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    @NotNull
    private String name;

    @Column
    @NotNull
    private String brand;

    @Column
    @NotNull
    private String description;

    @Column
    @NotNull
    private Float price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_shop",
            joinColumns = @JoinColumn(name = "prod_id", referencedColumnName = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cart_id"))
    private List<Cart> cart;


    public Product() {

    }


}

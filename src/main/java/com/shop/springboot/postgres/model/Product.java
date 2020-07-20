package com.shop.springboot.postgres.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Таблица товары
 * @author Streltsov Ivan
 * @version  1.0
 */

@Entity
public class Product {

    @Id
    @Column(name = "prod_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String brand;

    @Column
    private String description;

    @Column
    private Float price;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "product_shop",
            joinColumns = @JoinColumn(name = "prod_id", referencedColumnName = "prod_id"),
            inverseJoinColumns = @JoinColumn(name = "cart_id", referencedColumnName = "cart_id"))
    private List<Cart> cart;


    public Product() {

    }


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String model) {

        this.name = model;
    }

    public String getBrand() {

        return brand;
    }

    public void setBrand(String marke) {

        this.brand = marke;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public Float getPrice() {

        return price;
    }

    public void setPrice(Float price) {

        this.price = price;
    }

    public List<Cart> getCart() {
        return cart;
    }

    public void setCart(List<Cart> cart) {
        this.cart = cart;
    }

}

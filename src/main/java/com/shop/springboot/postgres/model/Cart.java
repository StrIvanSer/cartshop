package com.shop.springboot.postgres.model;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * Таблицы корзина
 * @author Streltsov Ivan
 * @version  1.0
 */

@Entity
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {

        this.email = email;
    }

    public Float getSum() {

        return sum;
    }

    public void setSum(Float sum) {

        this.sum = sum;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

}

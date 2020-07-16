package com.shop.springboot.postgres.model;


import net.bytebuddy.dynamic.loading.InjectionClassLoader;

import javax.persistence.*;

@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String product;

    private Integer value;

    private Float price;

    private String email;

    private Float sum;


    public Cart() {

    }

    public Cart(String product, Integer value, String email, Float sum , Float price) {

        this.product = product;
        this.value = value;
        this.email = email;
        this.sum = sum;
        this.price = price;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getProduct() {

        return product;
    }

    public void setProduct(String product) {

        this.product = product;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {

        this.value = value;
    }

    public String getEmail()    {
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
}

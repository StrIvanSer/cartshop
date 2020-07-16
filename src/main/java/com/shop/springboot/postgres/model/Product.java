package com.shop.springboot.postgres.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String brand;
    private String description;
    private Float price;


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

}

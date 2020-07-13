package com.shop.springboot.postgres.service;
import com.shop.springboot.postgres.model.Product;
import com.shop.springboot.postgres.repo.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class AutoService {
 
    @Autowired
    private ProductRepository repo;
     
    public List<Product> listAll() {

        return repo.findAll();
    }
     
    public void save(Product product) {

        repo.save(product);
    }
     
    public Product get(long id) {
        return
                repo.findById(id).get();
    }
     
    public void delete(long id) {

        repo.deleteById(id);
    }
}

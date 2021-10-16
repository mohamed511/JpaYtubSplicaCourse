package com.ant.learn.service;

import com.ant.learn.entity.Product;
import com.ant.learn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void addProduct(String name) {
        Product product = new Product(name);
        this.productRepository.save(product);
    }

    public List<Product> findAllProducts() {
        return this.productRepository.findAll();
    }
}

package com.ant.learn.controller;

import com.ant.learn.entity.Product;
import com.ant.learn.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add/{name}")
    public void addProduct(@PathVariable("name") String name) {
        this.productService.addProduct(name);
    }

    @GetMapping("/getAll")
    public List<Product> findAllProducts() {
        return this.productService.findAllProducts();
    }
}

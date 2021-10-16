package main;

import entity.Product;
import service.ProductService;

import javax.persistence.*;
import java.util.List;

public class main {
    public static void main(String[] args) {
        ProductService service = new ProductService();
        service.addProduct("Aly");
        service.addProduct("Mohamed");
        List<Product> products = service.findAllProducts();
        products.forEach(System.out::println);
    }
}

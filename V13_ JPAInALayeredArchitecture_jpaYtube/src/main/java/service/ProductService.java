package service;

import entity.Product;
import repository.ProductRepo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class ProductService {
    private final EntityManagerFactory emf;

    public ProductService() {
        this.emf = Persistence.createEntityManagerFactory("my-persistence-unit");
    }

    public void addProduct(String name) {
        EntityManager em = emf.createEntityManager();
        ProductRepo productRepo = new ProductRepo(em);
        Product product = new Product(name);
        product.setName(name);
        try {
            em.getTransaction().begin();
            System.out.println("============> Start Add Product... ");
            productRepo.addProduct(product);
            System.out.println("===============> End Add Product !!!");
            em.getTransaction().commit();// insert to the database
        } catch (RuntimeException e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        } finally {
            em.close();
        }
    }

    public List<Product> findAllProducts() {
        EntityManager em = emf.createEntityManager();
        ProductRepo productRepo = new ProductRepo(em);
        return productRepo.findAllProducts();
    }
}

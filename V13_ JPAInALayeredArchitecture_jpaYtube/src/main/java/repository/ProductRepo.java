package repository;

import entity.Product;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

public class ProductRepo {
    private final EntityManager em;

    public ProductRepo(EntityManager em) {
        this.em = em;
    }

    public void addProduct(Product product) {
        em.persist(product);
    }

    public List<Product> findAllProducts() {
        String jpql = "SELECT p FROM Product p";
        TypedQuery<Product> tq = em.createQuery(jpql, Product.class);
        return tq.getResultList();
    }
}

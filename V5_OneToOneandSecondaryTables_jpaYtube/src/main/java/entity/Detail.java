package entity;

import javax.persistence.*;

@Entity
@Table(name = "detail")
public class Detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int kcal;
    //@OneToOne(cascade = CascadeType.PERSIST)
    @OneToOne
    @JoinColumn(name = "product_id")
    private Product product;

    public Detail() {
    }

    public Detail(int kcal, Product product) {
        this.kcal = kcal;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getKcal() {
        return kcal;
    }

    public void setKcal(int kcal) {
        this.kcal = kcal;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "id=" + id +
                ", kcal=" + kcal +
                '}';
    }
}

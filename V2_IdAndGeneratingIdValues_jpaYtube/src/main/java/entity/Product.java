package entity;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "product")
public class Product {
    @Id
    @TableGenerator(name="any_generator",
            table = "my_generator",
            pkColumnName = "test_name",
            pkColumnValue = "product_seq",
            valueColumnName = "test_value")
    @GeneratedValue(strategy = GenerationType.TABLE,generator = "any_generator")
    private Integer id;
    //@Basic(optional = false)
    private String name;
    private double price;
    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    //getter and setter
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDate expirationDate) {
        this.expirationDate = expirationDate;
    }
}

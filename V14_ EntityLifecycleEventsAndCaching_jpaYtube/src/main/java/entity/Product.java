package entity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Cacheable(false)
public class Product extends GeneralEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


    public Product() {
    }

    public Product(String name) {
        this.name = name;
    }
    //getter and setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", createdDate=" + createdDate +
                ", modifiedDate=" + modifiedDate +
                '}';
    }

    @PostLoad
    public void postLoad() {
        System.out.println("Entity " + this + " was loaded!");
    }

    @PreRemove
    public void preRemove() {
        System.out.println("Entity will be remove!");
        System.out.println(this);
    }

    @PostRemove
    public void postRemove() {
        System.out.println("Entity was remove!");
        System.out.println(this);
    }

}

package entity;

import entity.embeddable.Address;

import javax.persistence.*;

@Entity
@Table(name = "company")
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverride(name = "buildingNo", column = @Column(name = "building_num"))
    @AttributeOverride(name = "str", column = @Column(name = "street"))
    @AttributeOverride(name = "city", column = @Column(name = "city"))
    private Address address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}

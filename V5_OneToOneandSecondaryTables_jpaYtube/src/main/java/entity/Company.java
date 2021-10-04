package entity;

import javax.persistence.*;

@Entity
@Table(name = "company")
@SecondaryTables({
        @SecondaryTable(name = "address",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "comp_id")),
        @SecondaryTable(name = "miscellaneous",
                pkJoinColumns = @PrimaryKeyJoinColumn(name = "comp_id"))
})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(table = "company", name = "name")
    private String name;
    @Column(table = "address", name = "street")
    private String street;
    @Column(table = "address", name = "number")
    private String number;
    @Column(table = "miscellaneous", name = "details")
    private String details;

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

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}

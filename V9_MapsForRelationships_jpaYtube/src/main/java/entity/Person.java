package entity;

import entity.enums.PhoneType;

import javax.persistence.*;
import java.util.Map;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "person_name")
    private String name;
    @ElementCollection
    @CollectionTable(name = "phone", joinColumns = @JoinColumn(name = "person"))
    @MapKeyColumn(name = "type")
    @Column(name = "number")
    @MapKeyEnumerated(EnumType.STRING)
    private Map<PhoneType,String> phoneNumbers;

    public Person() {
    }

    public Person(String name, Map<PhoneType, String> phoneNumbers) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
    }

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

    public Map<PhoneType, String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(Map<PhoneType, String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }
}

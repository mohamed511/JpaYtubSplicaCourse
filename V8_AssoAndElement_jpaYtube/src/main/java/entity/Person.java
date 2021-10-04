package entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "person_name")
    private String name;
    @ElementCollection
    @CollectionTable(name = "phone",joinColumns = @JoinColumn(name = "person"))
    @Column(name = "number")
    private List<String> phoneNumbers;

    @ElementCollection
    @CollectionTable(name = "document",joinColumns = @JoinColumn(name = "person"))
    @AttributeOverride(name = "reference",column = @Column(name = "refrence"))
    private List<Document> documents;

    public Person() {
    }

    public Person(String name, List<String> phoneNumbers, List<Document> documents) {
        this.name = name;
        this.phoneNumbers = phoneNumbers;
        this.documents = documents;
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

    public List<String> getPhoneNumbers() {
        return phoneNumbers;
    }

    public void setPhoneNumbers(List<String> phoneNumbers) {
        this.phoneNumbers = phoneNumbers;
    }

    public List<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(List<Document> documents) {
        this.documents = documents;
    }
}

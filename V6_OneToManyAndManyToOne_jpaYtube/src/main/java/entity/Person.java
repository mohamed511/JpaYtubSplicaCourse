package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "persons")
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "person_id")
    private int id;
    @Column(name = "person_name")
    private String personName;

    @OneToMany(mappedBy = "person", cascade = CascadeType.PERSIST)
    // Collection, List, Set
    private Collection<Document> documents;

    public Person() {
    }

    public Person(String personName) {
        this.personName = personName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public Collection<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Collection<Document> documents) {
        this.documents = documents;
    }
}

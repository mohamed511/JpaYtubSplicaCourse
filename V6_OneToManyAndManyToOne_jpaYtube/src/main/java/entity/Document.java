package entity;

import javax.persistence.*;

@Entity
@Table(name = "documents")
public class Document {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "document_id")
    private int id;
    @Column(name = "document_name")
    private String documentName;
    @ManyToOne(cascade = CascadeType.PERSIST, optional = false)
    @JoinColumn(name = "person_id")
    private Person person;

    public Document() {
    }

    public Document(String documentName) {
        this.documentName = documentName;
    }

    public Document(String documentName, Person person) {
        this.documentName = documentName;
        this.person = person;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDocumentName() {
        return documentName;
    }

    public void setDocumentName(String documentName) {
        this.documentName = documentName;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}

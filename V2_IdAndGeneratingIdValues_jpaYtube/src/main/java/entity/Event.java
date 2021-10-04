package entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "event")
public class Event {
    @Id
    @GenericGenerator(name="myUUID", strategy = "org.hibernate.id.UUIDHexGenerator"
            ,parameters = @org.hibernate.annotations.Parameter(name="separator",value="."))
    @GeneratedValue(generator = "myUUID")
    private String id;
    @Column(name = "description")
    private String description;

    public Event() {
        //this.id = UUID.randomUUID().toString();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

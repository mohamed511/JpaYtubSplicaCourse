package entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.util.UUID;


@Entity
@Table(name = "event")
public class Event {
    @Id
    @GenericGenerator(name="myUUID", strategy = "org.hibernate.id.UUIDHexGenerator"
            ,parameters = @Parameter(name="separator",value="."))
    @GeneratedValue(generator = "myUUID")
    private String id;
    @Column(name = "description")
    private String description;

    @Column(name = "event_time")
    private LocalDateTime eventTime;

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

    public LocalDateTime getEventTime() {
        return eventTime;
    }

    public void setEventTime(LocalDateTime eventTime) {
        this.eventTime = eventTime;
    }
}

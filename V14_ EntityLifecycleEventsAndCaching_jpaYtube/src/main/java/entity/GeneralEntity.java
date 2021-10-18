package entity;

import javax.persistence.*;
import java.time.LocalDateTime;

@MappedSuperclass
public class GeneralEntity {
    @Column(name = "date_created")
    protected LocalDateTime createdDate;
    @Column(name = "date_modified")
    protected LocalDateTime modifiedDate;
    //Getter and Setter

    public LocalDateTime getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDateTime createdDate) {
        this.createdDate = createdDate;
    }

    public LocalDateTime getModifiedDate() {
        return modifiedDate;
    }

    public void setModifiedDate(LocalDateTime modifiedDate) {
        this.modifiedDate = modifiedDate;
    }

    @PrePersist
    public void prePersist() {
        this.createdDate = LocalDateTime.now();
        this.modifiedDate = LocalDateTime.now();
    }

    @PreUpdate
    public void preUpdate() {
        this.modifiedDate = LocalDateTime.now();
    }
}

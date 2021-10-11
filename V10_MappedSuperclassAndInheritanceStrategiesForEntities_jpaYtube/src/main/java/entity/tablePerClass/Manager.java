package entity.tablePerClass;

import javax.persistence.Entity;

@Entity
public class Manager extends Employee{
    private String responsibility;
    // getter setter

    public String getResponsibility() {
        return responsibility;
    }

    public void setResponsibility(String responsibility) {
        this.responsibility = responsibility;
    }
}

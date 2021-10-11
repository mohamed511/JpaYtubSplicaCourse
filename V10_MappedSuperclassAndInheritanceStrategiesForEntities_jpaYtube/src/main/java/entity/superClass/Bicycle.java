package entity.superClass;

import javax.persistence.Entity;

@Entity
public class Bicycle extends Vehicle {
    private String model;
    // getter and setter


    public Bicycle() {
    }

    public Bicycle(String model) {
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}

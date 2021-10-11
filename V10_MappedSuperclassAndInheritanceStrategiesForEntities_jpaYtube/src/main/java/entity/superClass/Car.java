package entity.superClass;

import javax.persistence.Entity;

@Entity
public class Car extends Vehicle {
    private String gas;
    // getter and setter


    public Car() {
    }

    public Car(String gas) {
        this.gas = gas;
    }

    public String getGas() {
        return gas;
    }

    public void setGas(String gas) {
        this.gas = gas;
    }
}

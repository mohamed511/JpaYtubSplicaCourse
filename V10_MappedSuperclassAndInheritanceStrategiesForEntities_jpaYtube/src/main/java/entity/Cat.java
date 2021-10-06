package entity;

import javax.persistence.Entity;

@Entity
public class Cat extends Animal{
    private String color;
    // getter and setter

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}

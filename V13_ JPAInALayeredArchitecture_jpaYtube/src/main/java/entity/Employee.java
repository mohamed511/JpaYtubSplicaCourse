package entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Employee {
    @Id
    private int id;
    private String name;
    @ManyToOne
    private Department department;
    public Employee() {
    }
    public Employee(int id, String name, Department department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }
    // getter and setter

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

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", department=" + department +
                '}';
    }
}

package entity;

import entity.pk.DepartmentPk;

import javax.persistence.*;

@Entity
@Table(name = "department")
@IdClass(DepartmentPk.class)
public class Department {
    @Id
    @Column(name = "dept_code")
    private String code;
    @Id
    @Column(name = "dept_number")
    private int number;
    @Column(name = "name")
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

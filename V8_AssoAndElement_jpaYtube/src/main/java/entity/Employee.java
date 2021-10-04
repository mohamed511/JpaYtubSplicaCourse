package entity;

import javax.persistence.*;

@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Embedded
    @AttributeOverride(name = "contractNo", column = @Column(name = "contract_no"))
    @AssociationOverride(name = "department", joinColumns = @JoinColumn(name = "department"))
    private DepartmentDetail departmentDetail;

    public Employee() {
    }

    public Employee(String name, DepartmentDetail departmentDetail) {
        this.name = name;
        this.departmentDetail = departmentDetail;
    }

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

    public DepartmentDetail getDepartmentDetail() {
        return departmentDetail;
    }

    public void setDepartmentDetail(DepartmentDetail departmentDetail) {
        this.departmentDetail = departmentDetail;
    }
}

package entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DepartmentDetail {
    private String contractNo;
    @ManyToOne
    private Department department;

    public DepartmentDetail() {
    }

    public DepartmentDetail(String contractNo, Department department) {
        this.contractNo = contractNo;
        this.department = department;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

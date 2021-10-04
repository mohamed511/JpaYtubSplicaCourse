package entity.pk;

import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

public class DepartmentPk implements Serializable {
    private String code;
    private int number;

    public DepartmentPk() {
    }

    public DepartmentPk(String code, int number) {
        this.code = code;
        this.number = number;
    }

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
}

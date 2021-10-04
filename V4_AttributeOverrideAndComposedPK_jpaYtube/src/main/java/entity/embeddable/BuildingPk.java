package entity.embeddable;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
public class BuildingPk implements Serializable {
    private int number;
    private String code;

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

package entity.embeddable;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
    private String buildingNo;
    private String str;
    private String city;

    public Address() {
    }

    public Address(String buildingNo, String str, String city) {
        this.buildingNo = buildingNo;
        this.str = str;
        this.city = city;
    }

    public String getBuildingNo() {
        return buildingNo;
    }

    public void setBuildingNo(String buildingNo) {
        this.buildingNo = buildingNo;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

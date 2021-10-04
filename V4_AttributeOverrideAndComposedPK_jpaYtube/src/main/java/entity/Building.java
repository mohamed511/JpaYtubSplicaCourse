package entity;

import entity.embeddable.BuildingPk;

import javax.persistence.*;

@Entity
@Table(name = "building")
public class Building {
    @EmbeddedId
    @AttributeOverride(name = "code", column = @Column(name = "building_code"))
    @AttributeOverride(name = "number", column = @Column(name = "building_number"))
    private BuildingPk buildingPk;
    private String name;

    public BuildingPk getBuildingPk() {
        return buildingPk;
    }

    public void setBuildingPk(BuildingPk buildingPk) {
        this.buildingPk = buildingPk;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

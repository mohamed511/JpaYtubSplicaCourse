package entity;

import javax.persistence.Embeddable;
import javax.persistence.ManyToMany;
import java.util.List;

@Embeddable
public class ProfessorDetail {
    @ManyToMany
    private List<Professor> professors;

    public ProfessorDetail() {
    }

    public ProfessorDetail(List<Professor> professors) {
        this.professors = professors;
    }

    public List<Professor> getProfessors() {
        return professors;
    }

    public void setProfessors(List<Professor> professors) {
        this.professors = professors;
    }
}

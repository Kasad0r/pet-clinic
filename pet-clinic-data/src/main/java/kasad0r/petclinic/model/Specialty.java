package kasad0r.petclinic.model;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Specialty extends BaseEntity {
    @Column(name = "description")
    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

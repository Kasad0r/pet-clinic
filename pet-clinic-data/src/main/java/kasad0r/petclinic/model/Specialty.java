package kasad0r.petclinic.model;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
public class Specialty extends BaseEntity {
    @Column(name = "description")
    private String description;

}

package kasad0r.petclinic.model;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;


@Data
@Entity
@Table(name = "pets")
public class Pet extends BaseEntity {

    @ManyToOne
    @JoinColumn(name = "type_id")
    private PetType petType;

    @ManyToOne()
    @JoinColumn(name = "owner_id")
    private Owner owner;

    @Column(name = "birth_day")
    private LocalDate birthday;

    @Column(name = "name")
    private String name;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "pet")
    private Set<Visit> visits = new HashSet<>();

}



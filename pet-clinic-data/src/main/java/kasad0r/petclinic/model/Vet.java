package kasad0r.petclinic.model;

import java.util.Set;

public class Vet extends Person {
    public Set<Specialty> getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Set<Specialty> specialty) {
        this.specialty = specialty;
    }

    private Set<Specialty> specialty;

}

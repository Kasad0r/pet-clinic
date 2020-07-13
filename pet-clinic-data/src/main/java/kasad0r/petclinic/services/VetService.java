package kasad0r.petclinic.services;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.model.Vet;

import java.util.Set;

public interface VetService {
    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> finAll();
}

package kasad0r.petclinic.services;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.model.Pet;

import java.util.Set;

public interface PetService {
    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> finAll();
}

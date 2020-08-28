package kasad0r.petclinic.services.map;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.model.Pet;
import kasad0r.petclinic.services.OwnerService;
import kasad0r.petclinic.services.PetService;
import kasad0r.petclinic.services.PetTypeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

    private final PetTypeService petTypeService;
    private final PetService petService;

    public OwnerServiceMap(PetTypeService petTypeService, PetService petService) {
        this.petTypeService = petTypeService;
        this.petService = petService;
    }

    @Override
    public Set<Owner> findAll() {
        return super.findAll();
    }

    @Override
    public Owner findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Owner save(Owner obj) {

        Owner savedOwner = null;

        if (obj != null) {
            if (obj.getPets() != null) {
                obj.getPets().forEach(pet -> {
                    if (pet.getPetType() != null) {
                        if (pet.getPetType().getId() == null) {
                            pet.setPetType(petTypeService.save(pet.getPetType()));
                        }
                    } else {
                        throw new RuntimeException("Pet Type is required");
                    }
                    if (pet.getId() == null) {
                        Pet savedPet = petService.save(pet);
                        pet.setId(savedPet.getId());
                    }
                });
            }
            return super.save(obj);

        } else {
            return null;
        }
    }

    @Override
    void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    void delete(Owner obj) {
        super.delete(obj);
    }

    @Override
    public Owner findByLastName(String lastName) {
        return null;
    }
}

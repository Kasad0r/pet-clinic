package kasad0r.petclinic.services.springdatajpa;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.repositories.OwnerRepository;
import kasad0r.petclinic.repositories.PetRepository;
import kasad0r.petclinic.repositories.PetTypeRepository;
import kasad0r.petclinic.services.OwnerService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * @author kasad0r
 * @created 22/09/2020-17:03
 * @project pet-clinic
 */
@Service
@Profile("springdatajpa")
public class OwnerSDJpaService implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final PetRepository petRepository;
    private final PetTypeRepository petTypeRepository;

    public OwnerSDJpaService(
            OwnerRepository ownerRepository,
            PetRepository petRepository,
            PetTypeRepository petTypeRepository) {
        this.ownerRepository = ownerRepository;
        this.petRepository = petRepository;
        this.petTypeRepository = petTypeRepository;
    }

    @Override
    public Owner findByLastName(String lastName) {
        return ownerRepository.findByLastName(lastName);
    }

    @Override
    public void delete(Owner owner) {
        ownerRepository.delete(owner);
    }

    @Override
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @Override
    public Set<Owner> findAll() {
        Set<Owner> ownerSet = new HashSet<>();
        ownerRepository.findAll().forEach(ownerSet::add);
        return ownerSet;
    }

    @Override
    public Owner save(Owner obj) {
        return ownerRepository.save(obj);
    }

    @Override
    public Owner findById(Long aLong) {
        return ownerRepository.findById(aLong).orElse(null);
    }

}

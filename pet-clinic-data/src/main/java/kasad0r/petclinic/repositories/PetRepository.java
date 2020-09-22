package kasad0r.petclinic.repositories;

import kasad0r.petclinic.model.Pet;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author kasad0r
 * @created 22/09/2020-16:55
 * @project pet-clinic
 */
@Repository
public interface PetRepository extends CrudRepository<Pet,Long> {
}

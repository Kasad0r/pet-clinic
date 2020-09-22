package kasad0r.petclinic.repositories;

import kasad0r.petclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kasad0r
 * @created 22/09/2020-17:05
 * @project pet-clinic
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {

}

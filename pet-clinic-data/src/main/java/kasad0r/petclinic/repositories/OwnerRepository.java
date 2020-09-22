package kasad0r.petclinic.repositories;

import kasad0r.petclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kasad0r
 * @created 22/09/2020-16:55
 * @project pet-clinic
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {
    Owner findByLastName(String lastName);
}

package kasad0r.petclinic.repositories;

import kasad0r.petclinic.model.Specialty;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kasad0r
 * @created 22/09/2020-16:56
 * @project pet-clinic
 */
public interface SpecialtyRepository extends CrudRepository<Specialty,Long> {
}

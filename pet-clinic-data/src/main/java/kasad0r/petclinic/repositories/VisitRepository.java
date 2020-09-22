package kasad0r.petclinic.repositories;

import kasad0r.petclinic.model.Visit;
import org.springframework.data.repository.CrudRepository;

/**
 * @author kasad0r
 * @created 22/09/2020-16:57
 * @project pet-clinic
 */
public interface VisitRepository extends CrudRepository<Visit, Long> {
}

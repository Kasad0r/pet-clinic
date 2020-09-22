package kasad0r.petclinic.services.map;

import kasad0r.petclinic.model.Visit;
import kasad0r.petclinic.services.VisitService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author kasad0r
 * @created 22/09/2020-19:37
 * @project pet-clinic
 */
@Service
@Profile({"default", "map"})
public class VisitMapService extends AbstractMapService<Visit, Long> implements VisitService {
    @Override
    public Set<Visit> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Visit t) {
        super.delete(t);
    }

    @Override
    public Visit findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Visit save(Visit obj) {
        if (obj.getPet() == null || obj.getPet().getOwner() == null || obj.getPet().getId() == null) {
            throw new RuntimeException("Invalid Visit");
        }
        return super.save(obj);
    }
}

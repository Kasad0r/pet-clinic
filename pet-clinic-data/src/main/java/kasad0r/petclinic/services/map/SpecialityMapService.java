package kasad0r.petclinic.services.map;

import kasad0r.petclinic.model.Specialty;
import kasad0r.petclinic.services.SpecialitesService;

import java.util.Set;

/**
 * @author kasad0r
 * @created 08/09/2020-16:52
 * @project pet-clinic
 */
public class SpecialityMapService extends AbstractMapService<Specialty, Long> implements SpecialitesService {
    @Override
    void deleteById(Long aLong) {
        super.deleteById(aLong);
    }

    @Override
    void delete(Specialty obj) {
        super.delete(obj);
    }

    @Override
    public Set<Specialty> findAll() {
        return super.findAll();
    }

    @Override
    public Specialty save(Specialty obj) {
        return super.save(obj);
    }

    @Override
    public Specialty findById(Long aLong) {
        return super.findById(aLong);
    }
}

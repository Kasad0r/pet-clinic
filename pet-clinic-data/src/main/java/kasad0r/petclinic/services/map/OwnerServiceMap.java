package kasad0r.petclinic.services.map;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.services.CrudService;
import kasad0r.petclinic.services.OwnerService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class OwnerServiceMap extends AbstractMapService<Owner, Long> implements OwnerService {

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
        return super.save(obj.getId(), obj);
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

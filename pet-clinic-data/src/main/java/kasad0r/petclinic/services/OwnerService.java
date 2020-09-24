package kasad0r.petclinic.services;

import kasad0r.petclinic.model.Owner;

import java.util.Set;

public interface OwnerService extends CrudService<Owner,Long> {
    Owner findByLastName(String lastName);

}

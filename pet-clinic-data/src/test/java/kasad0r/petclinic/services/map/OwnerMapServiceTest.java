package kasad0r.petclinic.services.map;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.services.PetService;
import kasad0r.petclinic.services.PetTypeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

/**
 * @author kasad0r
 * @created 23/09/2020-18:00
 * @project pet-clinic
 */
class OwnerMapServiceTest {

    PetTypeService petTypeService;
    PetService petService;
    OwnerMapService ownerMapService;
    final Long ownerId = 1L;
    final String lastName = "Kes";

    @BeforeEach
    void setUp() {
        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder().city("Kyiv").id(ownerId).lastName(lastName).build());
    }

    @Test
    void findAll() {
        Set<Owner> all = ownerMapService.findAll();
        assertEquals(1, all.size());
    }

    @Test
    void findById() {
        Owner owner = ownerMapService.findById(ownerId);
        assertEquals(ownerId, owner.getId());
    }

    @Test
    void save() {
        Owner owner2 = Owner.builder().id(2L).build();
        ownerMapService.save(owner2);
        Owner findOwner = ownerMapService.findById(owner2.getId());
        assertEquals(owner2, findOwner);
    }

    @Test
    void saveExistingId() {
        Long id = 2L;

        Owner owner2 = Owner.builder().id(id).build();
        Owner savedOwner = ownerMapService.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void saveWithoutId() {
        Owner savedOwner = ownerMapService.save(new Owner());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void deleteById() {
        ownerMapService.deleteById(ownerId);
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertEquals(0, ownerMapService.findAll().size());
    }

    @Test
    void findByLastName() {
        Owner byLastName = ownerMapService.findByLastName(lastName);
        assertNotNull(byLastName);
        assertEquals(ownerId, byLastName.getId());
    }
}
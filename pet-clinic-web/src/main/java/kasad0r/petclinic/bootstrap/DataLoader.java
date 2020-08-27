package kasad0r.petclinic.bootstrap;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.model.PetType;
import kasad0r.petclinic.model.Vet;
import kasad0r.petclinic.services.OwnerService;
import kasad0r.petclinic.services.PetTypeService;
import kasad0r.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog= new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat= new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Dmytro");
        owner1.setLastName("Proniakin");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anton");
        owner2.setLastName("Sladkoewka");

        ownerService.save(owner2);

        System.out.println("Load owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ilya");
        vet1.setLastName("Tverdyihui");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Varvara");
        vet2.setLastName("Odnolubka");

        vetService.save(vet2);

        System.out.println("Load vets...");

        System.out.println("Bootstrap data - DONE!");
    }
}

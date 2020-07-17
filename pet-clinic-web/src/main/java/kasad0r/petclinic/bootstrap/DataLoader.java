package kasad0r.petclinic.bootstrap;

import kasad0r.petclinic.model.Owner;
import kasad0r.petclinic.model.Pet;
import kasad0r.petclinic.model.PetType;
import kasad0r.petclinic.model.Vet;
import kasad0r.petclinic.services.OwnerService;
import kasad0r.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;


    public DataLoader(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {
        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Dmytro");
        owner1.setLastName("Proniakin");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anton");
        owner2.setLastName("Sladkoewka");

        ownerService.save(owner2);

        System.out.println("Load owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Ilya");
        vet1.setLastName("Tverdyihui");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("Varvara");
        vet2.setLastName("Odnolubka");

        vetService.save(vet2);

        System.out.println("Load vets...");

        System.out.println("Bootstrap data - DONE!");
    }
}

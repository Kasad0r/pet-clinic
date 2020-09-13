package kasad0r.petclinic.bootstrap;

import kasad0r.petclinic.model.*;
import kasad0r.petclinic.services.OwnerService;
import kasad0r.petclinic.services.PetTypeService;
import kasad0r.petclinic.services.SpecialtyService;
import kasad0r.petclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoader implements CommandLineRunner {
    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialtyService specialtyService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, SpecialtyService specialtyService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialtyService = specialtyService;
    }

    @Override
    public void run(String... args) throws Exception {
        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }
    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        cat.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);


        Specialty radiology = new Specialty();
        radiology.setDescription("Radiology");
        Specialty savedRadiology = specialtyService.save(radiology);

        Specialty surgery = new Specialty();
        radiology.setDescription("Surgery");
        Specialty savedSurgery = specialtyService.save(surgery);

        Specialty dentistry = new Specialty();
        radiology.setDescription("Dentistry");
        Specialty savedDentistry = specialtyService.save(dentistry);

        Owner owner1 = new Owner();
        owner1.setFirstName("Dmytro");
        owner1.setLastName("Proniakin");
        owner1.setAddress("9, Ushynskogo st.");
        owner1.setCity("Kyiv");
        owner1.setTelephone("+380957635845");
        ownerService.save(owner1);

        Pet dimasPet = new Pet();
        dimasPet.setPetType(savedDogPetType);
        dimasPet.setBirthday(LocalDate.now());
        dimasPet.setOwner(owner1);
        dimasPet.setName("Uzik");


        owner1.getPets().add(dimasPet);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anton");
        owner2.setLastName("Sladkoewka");
        owner2.setAddress("Kostenko st.");
        owner2.setCity("Krukiwshchyna");
        owner2.setTelephone("+3809314927593");
        ownerService.save(owner2);

        Pet antoninaPet = new Pet();
        antoninaPet.setPetType(savedCatPetType);
        antoninaPet.setBirthday(LocalDate.of(2019, 10, 1));
        antoninaPet.setOwner(owner2);
        antoninaPet.setName("Antonina");

        System.out.println("Load owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Ilya");
        vet1.setLastName("Tverdyihui");
        vet1.getSpecialties().add(savedRadiology);
        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Varvara");
        vet2.setLastName("Odnolubka");
        vet2.getSpecialties().add(savedSurgery);
        vetService.save(vet2);

        System.out.println("Load vets...");

        System.out.println("Bootstrap data - DONE!");
    }
}

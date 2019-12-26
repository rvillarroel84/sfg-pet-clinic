package com.villarroel.sfgpetclinic.bootstrap;

import com.villarroel.sfgpetclinic.model.Owner;
import com.villarroel.sfgpetclinic.model.Pet;
import com.villarroel.sfgpetclinic.model.PetType;
import com.villarroel.sfgpetclinic.model.Vet;
import com.villarroel.sfgpetclinic.services.OwnerService;
import com.villarroel.sfgpetclinic.services.PetTypeService;
import com.villarroel.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

//    public DataLoad() {
//        ownerService = new OwnerServiceMap();
//        vetService = new VetServiceMap();
//
//    }


    @Override
    public void run(String... args){

        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatType = petTypeService.save(cat);

        Owner owner = new Owner();
        owner.setFirstName("Ronny");
        owner.setLastName("Villarroel");
        owner.setAddress("492 Changos");
        owner.setCity("Santa Cruz");
        owner.setTelephone("75563350");

        Pet mikesPet = new Pet();
        mikesPet.setPetType(savedDogType);
        mikesPet.setOwner(owner);
        mikesPet.setBirthDate(LocalDate.now());
        mikesPet.setName("Yoy");
        owner.getPets().add(mikesPet);
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setFirstName("Anahi");
        owner2.setLastName("Villarroel");
        owner2.setAddress("492 Pirai");
        owner2.setCity("Beni");
        owner2.setTelephone("65563350");

        Pet fionasCat = new Pet();
        fionasCat.setName("Just Cat");
        fionasCat.setOwner(owner2);
        fionasCat.setBirthDate(LocalDate.now());
        fionasCat.setPetType(savedCatType);
        owner2.getPets().add(fionasCat);

        ownerService.save(owner2);

//        System.out.println("Carga de Due;os");
        Vet vet = new Vet();
        vet.setFirstName("Seth");
        vet.setLastName("Godin8");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jorge");
        vet2.setLastName("Washington");

        vetService.save(vet2);

//        System.out.println("Carga de Veterinarios");

//        Owner owner3 = ownerService.findById(1L);

//        System.out.println(owner3.getLastName());

        for (Owner duendes : ownerService.findAll() ){
            System.out.println("ID: " + duendes.getId());
            System.out.println("Primer Nombre: " + duendes.getFirstName());
            System.out.println("Segundo Nombre: " + duendes.getLastName());
        }


//        System.out.println(owner.getFirstName() + " " + owner.getLastName());
//        System.out.println(owner2.getFirstName() + " " + owner2.getLastName());


//        System.out.println(vet.getLastName());

    }
}

package com.villarroel.sfgpetclinic.bootstrap;

import com.villarroel.sfgpetclinic.model.*;
import com.villarroel.sfgpetclinic.services.OwnerService;
import com.villarroel.sfgpetclinic.services.PetTypeService;
import com.villarroel.sfgpetclinic.services.VetService;
import com.villarroel.sfgpetclinic.services.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final VisitService visitService;

    public DataLoad(OwnerService ownerService, VetService vetService, PetTypeService petTypeService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.visitService = visitService;
    }

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

        //owner.builder().id(1).firstName("Ronny").telephone("75563350").lastName("Villarroel").build();


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
        Visit catVisit = new Visit();
        catVisit.setPet(fionasCat);
        catVisit.setDate(LocalDate.now());
        catVisit.setDescription("Snezzy Kitty");


//        System.out.println("Carga de Due;os");
        Vet vet = new Vet();
        vet.setFirstName("Seth");
        vet.setLastName("Godin8");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setFirstName("Jorge");
        vet2.setLastName("Washington");

        vetService.save(vet2);

        System.out.println("Loaded Vets");



    }
}

package com.villarroel.sfgpetclinic.bootstrap;

import com.villarroel.sfgpetclinic.model.Owner;
import com.villarroel.sfgpetclinic.model.Vet;
import com.villarroel.sfgpetclinic.services.OwnerService;
import com.villarroel.sfgpetclinic.services.VetService;
import com.villarroel.sfgpetclinic.services.map.OwnerServiceMap;
import com.villarroel.sfgpetclinic.services.map.VetServiceMap;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoad implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;

    public DataLoad(OwnerService ownerService, VetService vetService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    public DataLoad() {
        ownerService = new OwnerServiceMap();
        vetService = new VetServiceMap();

    }


    @Override
    public void run(String... args) throws Exception {

        Owner owner = new Owner();
        owner.setId(1L);
        owner.setFirstName("Ronny");
        owner.setLastName("Villarroel");
        ownerService.save(owner);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anahi");
        owner2.setLastName("Villarroel");
        ownerService.save(owner2);

//        System.out.println("Carga de Due;os");
        Vet vet = new Vet();
        vet.setId(1L);
        vet.setFirstName("Jorge");
        vet.setLastName("Pum");

        vetService.save(vet);

        Vet vet2 = new Vet();
        vet2.setId(1L);
        vet2.setFirstName("Jorge");
        vet2.setLastName("Pum");

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

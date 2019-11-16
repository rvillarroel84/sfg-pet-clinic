package com.villarroel.sfgpetclinic.bootstrap;

import com.rvillarroel.sfgpetclinic.services.OwnerService;
import com.rvillarroel.sfgpetclinic.services.VetService;
import com.rvillarroel.sfgpetclinic.services.map.OwnerServiceMap;
import com.rvillarroel.sfgpetclinic.services.map.VetServiceMap;
import com.villarroel.sfgpetclinic.model.Owner;
import com.villarroel.sfgpetclinic.model.Vet;
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
        owner2.setId(1L);
        owner2.setFirstName("Anahi");
        owner2.setLastName("Villarroel");
        ownerService.save(owner2);

        System.out.println("Carga de Due;os");
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

        System.out.println("Carga de Veterinarios");

        System.out.println(owner.getLastName());
        System.out.println(vet.getLastName());

    }
}

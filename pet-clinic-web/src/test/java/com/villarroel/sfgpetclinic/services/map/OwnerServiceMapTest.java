package com.villarroel.sfgpetclinic.services.map;

import com.villarroel.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerServiceMapTest {


    final long ownerId = 1L;
    final String lastName = "Smith";
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());
        ownerServiceMap.save(Owner.builder().id(ownerId).lastName("Smith").build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerServiceMap.findAll();
        assertEquals(1, owners.size());
    }

    @Test
    void findById() {

        Owner owner = ownerServiceMap.findById(ownerId);
        assertEquals(ownerId, owner.getId().longValue());
    }


    @Test
    void deleteById() {

        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void delete() {

        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));
        assertEquals(0, ownerServiceMap.findAll().size());
    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner owner2= Owner.builder().id(id).build();

        Owner savedOwner = ownerServiceMap.save(owner2);

        assertEquals(id, savedOwner.getId());
    }

    @Test
    void savedNoId(){
        Owner savedOwner = ownerServiceMap.save(Owner.builder().build());

        assertNotNull(savedOwner);
        assertNotNull(savedOwner.getId());
    }


    @Test
    void findByLastName() {
        Owner smith = ownerServiceMap.findByLastName(lastName);
        assertNotNull(smith);
        assertEquals(ownerId, smith.getId().longValue());
    }
}
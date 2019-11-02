package com.rvillarroel.sfgpetclinic.services;

import com.villarroel.sfgpetclinic.model.Pet;

import java.util.List;

public interface PetService {

    Pet findById(Long id);
    Pet save(Pet pet);
    List<Pet> findAll();
}

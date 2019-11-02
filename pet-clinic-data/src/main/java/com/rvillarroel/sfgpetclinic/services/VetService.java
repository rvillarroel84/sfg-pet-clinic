package com.rvillarroel.sfgpetclinic.services;

import com.villarroel.sfgpetclinic.model.Vet;

import java.util.List;

public interface VetService {

    Vet findById(Long id);
    Vet save(Vet vet);
    List<Vet> findAll();
}

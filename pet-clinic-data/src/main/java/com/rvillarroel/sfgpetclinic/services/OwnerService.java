package com.rvillarroel.sfgpetclinic.services;

import com.villarroel.sfgpetclinic.model.Owner;

import java.util.List;

public interface OwnerService {

    Owner findByLastName(String lastName);
    Owner findById(Long id);
    Owner save(Owner owner);
    List<Owner> findAll();

}

package com.villarroel.sfgpetclinic.services.map;

import com.villarroel.sfgpetclinic.model.PetType;
import com.villarroel.sfgpetclinic.model.Speciality;
import com.villarroel.sfgpetclinic.services.SpecialtyService;

import java.util.Set;

public class SpecialtyServiceMap extends AbstractMapService<Speciality, Long> implements SpecialtyService{
    @Override
    public Set<Speciality> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Speciality object) {
        super.save(object);
    }

    @Override
    public Speciality save(Speciality object) {
        return super.save(object);
    }

    @Override
    public Speciality findById(Long id) {
        return super.findById(id);
    }


}

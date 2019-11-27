package com.villarroel.sfgpetclinic.services;

import com.villarroel.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

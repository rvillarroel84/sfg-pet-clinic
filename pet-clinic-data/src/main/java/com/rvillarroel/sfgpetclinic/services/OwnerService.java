package com.rvillarroel.sfgpetclinic.services;

import com.villarroel.sfgpetclinic.model.Owner;

public interface OwnerService extends CrudService<Owner, Long>{

    Owner findByLastName(String lastName);

}

package com.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.sports.model.Sports;
import com.sports.model.BusinessOwner;


public interface BusinessOwnerRepository  extends CrudRepository<BusinessOwner, String>{

}

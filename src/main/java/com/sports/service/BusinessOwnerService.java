package com.sports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.model.Sports;
import com.sports.model.BusinessOwner;

import com.sports.repository.BusinessOwnerRepository;

@Service
public class BusinessOwnerService {

	@Autowired
	BusinessOwnerRepository businessOwnerRepository;
	
	// saving user record
	public void saveOrUpdate(BusinessOwner businessOwner) {
		/*UUID uuid = UUID.randomUUID();
		sports.setSports_id(uuid.toString());*/
		businessOwnerRepository.save(businessOwner);
	}	
}

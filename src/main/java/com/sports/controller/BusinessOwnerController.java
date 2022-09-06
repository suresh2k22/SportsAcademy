package com.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sports.model.BusinessOwner;
import com.sports.service.BusinessOwnerService;

@RestController
public class BusinessOwnerController {

	@Autowired
	BusinessOwnerService businessOwnerService;
	
	@PostMapping("/businessOwner")
	private BusinessOwner addbusinessOwner(@RequestBody BusinessOwner businessOwner) {
		businessOwnerService.saveOrUpdate(businessOwner);
		return businessOwner;
	}
}

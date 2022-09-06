package com.sports.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sports.service.SportsService;
import java.util.List;

import com.sports.customidgenerator.SportsIdGenerator;
import com.sports.model.Sports;

@Validated
@RestController
@RequestMapping("/sports")
public class SportsController {

	@Autowired
	SportsService sportsService;	
	
	@GetMapping()
	private List<Sports> getAllSports() {
		return sportsService.getAllSports();
	}

	@GetMapping("/{sports_id}")
	private Sports getSports(@PathVariable("sports_id") String sports_id) {
		
		return sportsService.getSportsById(sports_id); 
	}
	
	@DeleteMapping("/{sports_id}")
	private void deleteSports(@PathVariable("sports_id") String sports_id) {
		sportsService.delete(sports_id);
	}
	
	@PostMapping()
	private Sports saveSports(@RequestBody Sports sports) {
		sportsService.saveOrUpdate(sports);
		return sports;
	}

	@PutMapping("/{sports_id}")
	private Sports updateSports(@PathVariable("sports_id") String sports_id, @RequestBody Sports sports) {
		sportsService.update(sports_id, sports);
		//if (sportsService.)
		return sports;
	}
}

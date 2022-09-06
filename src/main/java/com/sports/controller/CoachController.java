package com.sports.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sports.model.Coach;
import com.sports.service.CoachService;

@RestController
public class CoachController {

	@Autowired
	CoachService coachService;
	
	@GetMapping("/coach")
	private List<Coach> getAllCoachs() {
		return coachService.getAllCoach();
	}
	
	@GetMapping("/coach/{coach_id}")
	private Coach getCoachDetail (@PathVariable("coach_id") String coach_id) {
		return coachService.getCoachById(coach_id);
	}
	
	@DeleteMapping("/coach/{coach_id}")
	private void deleteCoach(@PathVariable("coach_id") String coach_id) {
		coachService.delete(coach_id);
	}
	
	@PostMapping("/coach")
	private Coach saveSport(@RequestBody Coach coach) {
		coachService.saveOrUpdate(coach);
		return coach;
	}
	
	@PutMapping("/coach/{coach_id}")
	private Coach updateSport(@PathVariable("coach_id") String coach_id, @RequestBody Coach coach) {
		coachService.update(coach_id, coach);
		return coach;
	}
}

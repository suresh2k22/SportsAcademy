package com.sports.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.model.Coach;
import com.sports.model.Student;
import com.sports.repository.CoachRepository;

@Service
public class CoachService {

	@Autowired
	CoachRepository coachRepository;

	//getting a all records by using the method findAll() of CrudRepository
	public List<Coach> getAllCoach(){
		List<Coach> coach = new ArrayList<Coach>();
		coachRepository.findAll().forEach(coach1 -> coach.add(coach1));
		return coach;
	}
	
	//getting a specific record by using the method findById() of CrudRepository
	public Coach getCoachById(String coach_id) {
		return coachRepository.findById(coach_id).get();
	}
	
	//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Coach coach) {
		UUID uuid = UUID.randomUUID();
		/*coach.setCoach_id(uuid.toString());*/
		//coach.setSports_id(null); //this one
		//coach.setUser_id(uuid.toString()); //this one
		coachRepository.save(coach);
	}

	//deleting a specific record by using the method deleteById() of CrudRepository
	public void delete(String coach_id) {
		coachRepository.deleteById(coach_id);
	}
	
	//updating a specific record by using the method save() of CrudRepository
	public void update(String coach_id,Coach coach) {		
		/*if (coachRepository.existsById(coach_id)) {
			coachRepository.save(coach);
		} else {
			System.out.println("Specified coach id not found (id): "+coach_id);
		}*/
		Optional<Coach> ch1 = coachRepository.findById(coach_id);
		if (!ch1.isPresent()) {
			System.out.println(coach_id);
		} else {
			Coach coach1 = ch1.get();
			coach1.setName(coach.getName());
			coach1.setAddress(coach.getAddress());
			//coach1.setSports_id(coach.getSports_id());
			//coach1.setUser_id(coach.getUser_id());
			coach1.setCreated_dt(coach.getCreated_dt());
			coach1.setCreated_by(coach.getCreated_by());
			coach1.setLast_updated_dt(coach.getLast_updated_dt());
			coach1.setLast_updated_by(coach.getLast_updated_by());
			coachRepository.save(coach1);
		}
	}
}

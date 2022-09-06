package com.sports.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.customidgenerator.SportsIdGenerator;
import com.sports.model.Coach;
import com.sports.model.Sports;
import com.sports.repository.SportsRepository;
import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.ArrayList;

@Service
public class SportsService {

	//@Autowired
	//SportsIdGenerator sportsIdGenerator;
	
	@Autowired
	SportsRepository sportsRepository;
	
	//getting a all records by using the method findAll() of CrudRepository
	public List<Sports> getAllSports() {		
		List<Sports> sports = new ArrayList<Sports>();
		sportsRepository.findAll().forEach(sports1 -> sports.add(sports1));		
		return sports;
	}
	
	//getting a specific record by using the method findById() of CrudRepository
	public Sports getSportsById(String sports_id) {
		return sportsRepository.findById(sports_id).get();
	}
	
	//saving a specific record by using the method save() of CrudRepository
	public void saveOrUpdate(Sports sports) {
		/*UUID uuid = UUID.randomUUID();
		sports.setSports_id(uuid.toString());*/
		sportsRepository.save(sports);
	}
	
	// deleting a specific record by using the method deleteById of CrudRepository
	public void delete(String sports_id) {
		sportsRepository.deleteById(sports_id);
	}
	
	// updating a specific record by using the method save() of CrudRepository
	public void update(String sports_id, Sports sports) {
		/*if (sportsRepository.existsById(sports_id)) {
			sportsRepository.save(sports);
		} else {
			System.out.println("Specified sports id not found (id): "+sports_id);
		}*/
		Optional<Sports> sp1 = sportsRepository.findById(sports_id);
		if (!sp1.isPresent()) {
			System.out.println(sports_id);
		} else {
			Sports sports1 = sp1.get();
			sports1.setSports_name(sports.getSports_name());
			sports1.setSports_type(sports.getSports_type());			
			sports1.setCreated_dt(sports.getCreated_dt());
			sports1.setCreated_by(sports.getCreated_by());
			sports1.setLast_updated_dt(sports.getLast_updated_dt());
			sports1.setLast_updated_by(sports.getLast_updated_by());
			sportsRepository.save(sports1);
		}	
	}
}

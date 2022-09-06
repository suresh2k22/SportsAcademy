package com.sports.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sports.model.Parent;
import com.sports.repository.ParentRepository;

@Service
public class ParentService {
	@Autowired
	ParentRepository parentRepository;

	public List<Parent> getAllParent() {
		List<Parent> parent = new ArrayList<Parent>();
		parentRepository.findAll().forEach(pare -> parent.add(pare));
		return parent;
	}

	public Parent getParentById(int id) {
		return parentRepository.findById(id).get();
	}

	public void saveOrUpdate(Parent parent) {
		parentRepository.save(parent);
	}

	public void delete(int id) {
		parentRepository.deleteById(id);
	}

	public void update(int id, Parent parent) {
		Optional<Parent> pare = parentRepository.findById(id);
		if (!pare.isPresent()) {
			System.out.println(id);
		}
		Parent parent1 = pare.get();
		parent1.setParent_id(parent1.getParent_id());
		parent1.setName(parent1.getName());
		parent1.setAddress(parent1.getAddress());
		parent1.setSsn_no(parent1.getSsn_no());
		
		parentRepository.save(parent1);
	}
}
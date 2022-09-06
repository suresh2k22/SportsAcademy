package com.sports.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sports.model.Parent;
import com.sports.service.ParentService;

@RestController
public class ParentController {
	@Autowired
	ParentService parentService;

	@GetMapping("/parent")
	private List<Parent> getAllParent() {
		return parentService.getAllParent();
	}

	@GetMapping("/getby/{id}")
	private Parent getParent(@PathVariable("id") int id) {
		return parentService.getParentById(id);
	}

	@DeleteMapping("/del/{id}")
	private void deleteParent(@PathVariable("id") int id) {
		parentService.delete(id);
	}

	@PostMapping("/post")
	private int saveParent(@RequestBody Parent parent) {
		parentService.saveOrUpdate(parent);
		return parent.getParent_id();
	}

	@PutMapping("/update/{id}")
	private void update(@PathVariable(value = "id") int id, @RequestBody Parent parent) {
		parentService.update(id, parent);
	}
}

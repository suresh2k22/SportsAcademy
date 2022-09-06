package com.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.sports.model.Coach;

public interface CoachRepository extends CrudRepository<Coach, String>{

}

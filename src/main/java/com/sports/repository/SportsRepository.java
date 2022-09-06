package com.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.sports.model.Sports;

public interface SportsRepository extends CrudRepository<Sports, String>{

}

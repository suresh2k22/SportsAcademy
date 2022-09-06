package com.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.sports.model.Parent;

public interface ParentRepository extends CrudRepository<Parent, Integer> {
}

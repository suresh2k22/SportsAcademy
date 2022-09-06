package com.sports.repository;

import org.springframework.data.repository.CrudRepository;

import com.sports.model.Student;

public interface StudentRepository extends CrudRepository<Student, Integer> {
}

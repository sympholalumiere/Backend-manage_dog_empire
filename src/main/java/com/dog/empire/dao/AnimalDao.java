package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Animal;

@Repository
public interface AnimalDao extends JpaRepository<Animal, Long> {
	
}

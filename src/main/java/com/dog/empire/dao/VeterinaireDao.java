package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Veterinaire;

@Repository
public interface VeterinaireDao extends JpaRepository<Veterinaire, Long> {

}

package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Entreprise;

@Repository
public interface EntrepriseDao extends JpaRepository<Entreprise, Long > {
}

package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Dresseur;

@Repository
public interface DresseurDao extends JpaRepository<Dresseur, Long>{

}

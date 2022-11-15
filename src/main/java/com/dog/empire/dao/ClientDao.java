package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Clients;

@Repository
public interface ClientDao extends JpaRepository<Clients , Long>{

}

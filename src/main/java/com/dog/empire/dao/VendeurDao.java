package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Vendeur;


@Repository
public interface VendeurDao extends JpaRepository<Vendeur, Long>{

}

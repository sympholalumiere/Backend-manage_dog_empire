package com.dog.empire.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dog.empire.model.Achat;


@Repository
public interface AchatDao extends JpaRepository<Achat, Long>{


    /*@Query("SELECT sum(Achat.prix) from Entity Achat")
        int sumPrix();
    */
    @Query(value = "SELECT sum(prix) FROM Achat")
    public Long PrixTotalAchat();
}

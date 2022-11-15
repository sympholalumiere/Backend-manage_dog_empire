package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Dresseur;


public interface DresseurService {
	 // Save operation
	Dresseur saveDresseur(Dresseur dresseur);
    
    //get by id
    public Dresseur getDresseurById(Long id);
    

 
    // Read operation
    List<Dresseur> fetchDresseurList();
    public List<Dresseur> getAllDresseurs();
 
    // Update operation ( modification)
    Dresseur updateDresseur(Dresseur dresseur, Long idresseur);
 
    // operation de suppression
    void deleteDresseurById(Long idresseur);

}

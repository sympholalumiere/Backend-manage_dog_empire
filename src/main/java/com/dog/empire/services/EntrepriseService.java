package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Entreprise;



public interface EntrepriseService {
	 // Save operation
	Entreprise saveEntreprise(Entreprise entreprise);
    
    //get by id
    public Entreprise getEntrepriseById(Long id);
    

 
    // Read operation
    List<Entreprise> fetchEntrepriseList();
    public List<Entreprise> getAllEntreprises();
 
    // Update operation ( modification)
    Entreprise updateEntreprise(Entreprise entreprise, Long id);
 
    // operation de suppression
    void deleteEntrepriseById(Long id);

}

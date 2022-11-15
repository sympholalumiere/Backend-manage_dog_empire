package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Vendeur;

public interface VendeurService {
	 // Save operation
		Vendeur saveVendeur(Vendeur vendeur);
	    
	    //get by id
	    public Vendeur getVendeurById(Long id);
	    

	 
	    // Read operation
	    List<Vendeur> fetchVendeurList();
	    public List<Vendeur> getAllVendeurs();
	 
	    // Update operation ( modification)
	    Vendeur updateVendeur(Vendeur vendeur, Long idvendeur);
	 
	    // operation de suppression
	    void deleteVendeurById(Long idvendeur);
}

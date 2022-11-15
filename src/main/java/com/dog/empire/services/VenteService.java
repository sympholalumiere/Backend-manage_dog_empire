package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Vente;

public interface VenteService {
	 // Save operation
	Vente saveVente(Vente vente);
    
    //get by id
    public Vente getVenteById(Long id);
    

 
    // Read operation
    List<Vente> fetchVenteList();
    public List<Vente> getAllVentes();
 
    // Update operation ( modification)
    Vente updateVente(Vente vente, Long idvente);
 
    // operation de suppression
    void deleteVenteById(Long idvente);

}

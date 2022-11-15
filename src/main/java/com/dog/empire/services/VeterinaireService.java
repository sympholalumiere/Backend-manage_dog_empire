package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Veterinaire;



public interface VeterinaireService {
	 // Save operation
    Veterinaire saveVeterinaire(Veterinaire veterinaire);
    
    //get by id
    public Veterinaire getVeterinaireById(Long id);
    

 
    // Read operation
    List<Veterinaire> fetchVeterinaireList();
    public List<Veterinaire> getAllVeterinaires();
 
    // Update operation ( modification)
    Veterinaire updateVeterinaire(Veterinaire veterinaire, Long idveterinaire);
 
    // operation de suppression
    void deleteVeterinaireById(Long idveterinaire);

}

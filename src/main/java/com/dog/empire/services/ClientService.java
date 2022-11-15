package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Clients;


public interface ClientService {
	 // Save operation
	Clients saveClients(Clients clients);
    
    //get by id
    public Clients getClientsById(Long id);
    

 
    // Read operation
    List<Clients> fetchClientsList();
    public List<Clients> getAllClients();
 
    // Update operation ( modification)
    Clients updateClients(Clients veterinaire, Long idclient);
 
    // operation de suppression
    void deleteClientsById(Long idclient);

}

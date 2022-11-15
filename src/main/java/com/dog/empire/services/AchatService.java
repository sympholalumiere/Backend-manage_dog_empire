package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Achat;



public interface AchatService {
	 // Save operation
    Achat saveAchat(Achat achat);
    
    //get by id
    public Achat getAchatById(Long id);
    
 

 
    // Read operation
    List<Achat> fetchAchatList();
    public List<Achat> getAllAchats();
 
    // Update operation
    Achat updateAchat(Achat achat, Long idachat);
 
    // Delete operation
    void deleteAchatById(Long idachat);

    public Long getAchatByprixTotal();

//    public Long PrixTotalAchat();


}

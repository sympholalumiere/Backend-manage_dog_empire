package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Achat;
import com.dog.empire.model.User;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;


public interface AchatService {
	 // Save operation
    Achat saveAchat(Achat achat);
    void addAchat(Achat achat, User user);

    //get by id
    public Achat getAchatById(Long idAchat);




    // Read operation
    List<Achat> fetchAchatList();
    public List<Achat> getAllAchats();

    // get achat by user
    List<Achat> fetchAchatListByUser(Long userId);


    // Update operation
    Achat updateAchat(Achat achat, Long idAchat);

    // Delete operation
    void deleteAchatById(Long idAchat);

    public Long getAchatByprixTotal();

//    public Long PrixTotalAchat();


    @Transactional
   Achat assignAchatToUser(Long idAchat, Long userId);

}

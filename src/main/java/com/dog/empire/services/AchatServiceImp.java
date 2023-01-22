package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import com.dog.empire.dao.UserDao;
import com.dog.empire.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dog.empire.dao.AchatDao;
import com.dog.empire.exception.AnimalNotFoundException;
import com.dog.empire.model.Achat;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
@Service
@Slf4j
public class AchatServiceImp implements AchatService{

	//Annotation
	 @Autowired
	 private AchatDao achatDao;
	 @Autowired
	 private UserDao userDao;

	 //enregistrer un achat
	@Override
	public Achat saveAchat(Achat achat) {
		return achatDao.save(achat);
	}
	// liste d'un achat par son id
	@Override
	public Achat getAchatById(Long idAchat) {
			   Optional<Achat> opt = achatDao.findById(idAchat);
				if(opt.isPresent()) {
					return opt.get();
				} else {
					throw new AnimalNotFoundException("achat avec id : "+idAchat+" n'exixte pas");
				}
	}

	// liste de tout les achats
	@Override
	public List<Achat> fetchAchatList() {
		 return (List<Achat>)
				 achatDao.findAll();
	}
// liste de tout les achats
	@Override
	public List<Achat> getAllAchats() {
		// TODO Auto-generated method stub
		return null;
	}

	// recuperer la liste des achats d'un user par son id
	@Override
	public List<Achat> fetchAchatListByUser(Long userId) {
		return (List<Achat>) achatDao.findAchatByUser((userDao.findUserByUserId(userId).get()));
	}

	// modifier l'achat'
	@Override
	public Achat updateAchat(Achat achat, Long idAchat) {
		Achat achatDB
        = achatDao.findById(idAchat).get();
		 return achatDao.save(achatDB);
	}
// supprimer un achat
	@Override
	public void deleteAchatById(Long idAchat) {
		achatDao.deleteById(idAchat);

	}
// recuper le prix total de tout les achats
	@Override
	public Long getAchatByprixTotal() {
		return achatDao.PrixTotalAchat();
	}


// assigner un achat à un user
	@Override
	@Transactional
	public Achat assignAchatToUser(Long idAchat, Long userId) {
		var achat = achatDao.findById(idAchat).get();
		var user = userDao.findById(userId).get();
		achat.assignUser(user);
		return achat;
	}



	// Create new achat for a user (get user by name)
	public void addAchat(Achat achat, User user) {
		achat.setUser(user);
		achatDao.save(achat);
	}

}

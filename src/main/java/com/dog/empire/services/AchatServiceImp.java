package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dog.empire.dao.AchatDao;
import com.dog.empire.exception.AnimalNotFoundException;
import com.dog.empire.model.Achat;



@Component
@Service
public class AchatServiceImp implements AchatService{

	//Annotation
	 @Autowired
	 private AchatDao achatDao;

	@Override
	public Achat saveAchat(Achat achat) {
		return achatDao.save(achat);
	}

	@Override
	public Achat getAchatById(Long id) {
			   Optional<Achat> opt = achatDao.findById(id);
				if(opt.isPresent()) {
					return opt.get();
				} else {
					throw new AnimalNotFoundException("achat avec id : "+id+" n'exixte pas");
				}
	}
	

	@Override
	public List<Achat> fetchAchatList() {
		 return (List<Achat>)
				 achatDao.findAll();
	}

	@Override
	public List<Achat> getAllAchats() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Achat updateAchat(Achat achat, Long idachat) {
		Achat achatDB
        = achatDao.findById(idachat).get();
		 return achatDao.save(achatDB);
	}

	@Override
	public void deleteAchatById(Long idachat) {
		achatDao.deleteById(idachat);
		
	}

	@Override
	public Long getAchatByprixTotal() {
		return achatDao.PrixTotalAchat();
	}
}

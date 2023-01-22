package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import com.dog.empire.dao.UserDao;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dog.empire.dao.VenteDao;
import com.dog.empire.exception.VenteNotFoundException;
import com.dog.empire.model.Vente;

@Component
@Service
public class VenteServiceImp implements VenteService {
	//Annotation
		 @Autowired
		 private VenteDao venteDao;
		 private UserDao userDao;
	@Override
	public Vente saveVente(Vente vente) {
		return venteDao.save(vente);
	}

	@Override
	public Vente getVenteById(Long id) {
		Optional<Vente> opt = venteDao.findById(id);
	    if(opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new VenteNotFoundException("Vente avec id : "+id+" n'exixte pas");
	    }
	}

	@Override
	public List<Vente> fetchVenteList() {
		return (List<Vente>)venteDao.findAll();
	}

	@Override
	public List<Vente> getAllVentes() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vente updateVente(Vente vente, Long idvente) {
		Vente venteDB
        = venteDao.findById(idvente).get();
		 return venteDao.save(venteDB);

	}

	@Override
	public void deleteVenteById(Long idvente) {
		venteDao.deleteById(idvente);

	}

	@Override
	public Vente assignVenteToUser(Long idVente, Long userId) {
		var vente = venteDao.findById(idVente).get();
		var user = userDao.findById(userId).get();
		vente.assignUser(user);
		return vente;
	}


}

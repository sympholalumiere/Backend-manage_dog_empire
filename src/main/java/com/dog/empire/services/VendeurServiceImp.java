package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.dog.empire.dao.VendeurDao;
import com.dog.empire.exception.VeterinaireNotFoundException;
import com.dog.empire.model.Vendeur;


@Component
@Service
public class VendeurServiceImp implements VendeurService{

	//Annotation
	 @Autowired
	 private VendeurDao vendeurDao;
	@Override
	public Vendeur saveVendeur(Vendeur vendeur) {
		return vendeurDao.save(vendeur);
	}

	@Override
	public Vendeur getVendeurById(Long id) {
		Optional<Vendeur> opt = vendeurDao.findById(id);
	    if(opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new VeterinaireNotFoundException("Veterinaire avec id : "+id+" n'exixte pas");
	    }
	}

	@Override
	public List<Vendeur> fetchVendeurList() {
		return (List<Vendeur>)vendeurDao.findAll();
	}

	@Override
	public List<Vendeur> getAllVendeurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Vendeur updateVendeur(Vendeur vendeur, Long idvendeur) {
		Vendeur vendeurDB
        = vendeurDao.findById(idvendeur).get();
		 return vendeurDao.save(vendeurDB);
		
	}

	@Override
	public void deleteVendeurById(Long idvendeur) {
		vendeurDao.deleteById(idvendeur);
		
	}

}

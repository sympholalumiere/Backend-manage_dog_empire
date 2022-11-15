package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dog.empire.dao.EntrepriseDao;
import com.dog.empire.exception.EntrepriseNotFoundException;
import com.dog.empire.model.Entreprise;

@Component
@Service
public class EntrepriseServiceImp  implements EntrepriseService{
	//Annotation
	 @Autowired
	 private EntrepriseDao entrepriseDao;

	@Override
	public Entreprise saveEntreprise(Entreprise entreprise){
		
		return entrepriseDao.save(entreprise);
	}

	@Override
	public Entreprise getEntrepriseById(Long id) {
		
		Optional<Entreprise> opt = entrepriseDao.findById(id);
	    if(opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new EntrepriseNotFoundException("Veterinaire avec id : "+id+" n'exixte pas");
	    }
	}

	@Override
	public List<Entreprise> fetchEntrepriseList() {
		
		return (List<Entreprise>)entrepriseDao.findAll();
	}

	@Override
	public List<Entreprise> getAllEntreprises() {
		
		return null;
	}

	@Override
	public Entreprise updateEntreprise(Entreprise entreprise, Long identreprise) {
		Entreprise entrepriseDB
        = entrepriseDao.findById(identreprise).get();
		 return entrepriseDao.save(entrepriseDB);
		
	}

	@Override
	public void deleteEntrepriseById(Long id) {
		entrepriseDao.deleteById(id);
		
}

}

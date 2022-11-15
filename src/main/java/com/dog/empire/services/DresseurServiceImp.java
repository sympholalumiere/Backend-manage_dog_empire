package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dog.empire.dao.DresseurDao;
import com.dog.empire.exception.DresseurNotFoundException;

import com.dog.empire.model.Dresseur;

@Component
@Service
public class DresseurServiceImp implements DresseurService{
	//Annotation
		 @Autowired
		 private DresseurDao dresseurDao;
	@Override
	public Dresseur saveDresseur(Dresseur dresseur) {
		return dresseurDao.save(dresseur);
	}

	@Override
	public Dresseur getDresseurById(Long id) {
		Optional<Dresseur> opt = dresseurDao.findById(id);
	    if(opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new DresseurNotFoundException("dresseur avec id : "+id+" n'exixte pas");
	    }
	}

	@Override
	public List<Dresseur> fetchDresseurList() {

		return (List<Dresseur>)dresseurDao.findAll();
	}

	@Override
	public List<Dresseur> getAllDresseurs() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Dresseur updateDresseur(Dresseur dresseur, Long idresseur) {
		Dresseur dresseurDB
        = dresseurDao.findById(idresseur).get();
		 return dresseurDao.save(dresseurDB);
	}

	@Override
	public void deleteDresseurById(Long idresseur) {
		dresseurDao.deleteById(idresseur);
		
	}



}

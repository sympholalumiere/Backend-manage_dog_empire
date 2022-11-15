package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


import com.dog.empire.dao.VeterinaireDao;
import com.dog.empire.exception.VeterinaireNotFoundException;
import com.dog.empire.model.Veterinaire;
@Component
@Service

public class VeterinaireServiceImp implements VeterinaireService{
	//Annotation
	 @Autowired
	 private VeterinaireDao veterinaireDao;

	@Override
	public Veterinaire saveVeterinaire(Veterinaire veterinaire) {
		
		return veterinaireDao.save(veterinaire);
	}

	@Override
	public Veterinaire getVeterinaireById(Long id) {
		
		Optional<Veterinaire> opt = veterinaireDao.findById(id);
	    if(opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new VeterinaireNotFoundException("Veterinaire avec id : "+id+" n'exixte pas");
	    }
	}

	@Override
	public List<Veterinaire> fetchVeterinaireList() {
		
		return (List<Veterinaire>)veterinaireDao.findAll();
	}

	@Override
	public List<Veterinaire> getAllVeterinaires() {
		
		return null;
	}

	@Override
	public Veterinaire updateVeterinaire(Veterinaire veterinaire, Long idveterinaire) {
		Veterinaire veterinaireDB
         = veterinaireDao.findById(idveterinaire).get();
		 return veterinaireDao.save(veterinaireDB);
		
	}

	@Override
	public void deleteVeterinaireById(Long idveterinaire) {
		veterinaireDao.deleteById(idveterinaire);
		
	}

}

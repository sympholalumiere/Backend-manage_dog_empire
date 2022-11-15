package com.dog.empire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


import org.springframework.web.bind.annotation.RestController;
import com.dog.empire.model.Veterinaire;
import com.dog.empire.services.VeterinaireService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
@Component
@RestController
public class VeterinaireController {

	 @Autowired 
	 private VeterinaireService veterinaireService;
	 //creer une methode de recuperation de tous les animaux depuis la BD
		
		@GetMapping(value ="/veterinaire/liste")
		public List<Veterinaire> getAllVeterinaires(){
			 List<Veterinaire> liste= new ArrayList<>();
			 veterinaireService.fetchVeterinaireList().forEach(liste::add);
			return liste;
		}

	 // Save operation
	 @PostMapping("/ajoute/veterinaire")

	 public Veterinaire saveVeterinaire(
	     @Validated @RequestBody Veterinaire veterinaire)
	 {
	     return veterinaireService.saveVeterinaire(veterinaire);
	 }
	 //
	 @RequestMapping(value="veterinaire/{id}",method=RequestMethod.GET)
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 public Veterinaire getVeterinaireById(@PathVariable("id") Long id) {

	     return veterinaireService.getVeterinaireById(id);
	 }

	 // tous les animaux
	 @GetMapping("/veterinaires")

	 public List<Veterinaire> fetchAnimalList()
	 {
	     return veterinaireService.fetchVeterinaireList();
	 }

	 // Update operation
	 @PutMapping("/veterinaires/{id}")

	 public Veterinaire updateVeterinaire(@RequestBody Veterinaire veterinaire, @PathVariable("id") Long idveterinaire)
	 {
	     return veterinaireService.updateVeterinaire(
	    		 veterinaire, idveterinaire);
	 }

	 // Delete operation
	 @DeleteMapping("/veterinaires/{id}")

	 public String deleteVeterinaireById(@PathVariable("id") Long idveterinaire)
	 {
		 veterinaireService.deleteVeterinaireById( idveterinaire);
	     return "Deleted Successfully";
	 }
	 
	 
	 
	/*
	@Autowired
	VeterinaireDao veterinaireDao;
    //creer une methode de recuperation de tous les animaux depuis la BD
	//liste de tous les veterinaires
	@GetMapping(value ="veterinaires/liste")
	public List<Veterinaire> getAllVeterinaire(){
		 List<Veterinaire> liste= new ArrayList<>();
		 veterinaireDao.findAll().forEach(liste::add);
		return liste;
	}

	 // Retourne un bailleur par son id 
    @RequestMapping(value="veterinaire/{id}",method=RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Veterinaire getVeterinaireById(@PathVariable("id") Long id) {

        return veterinaireDao.findById(id).get();
    }
    //Enregistre un nouvel animal
    @PostMapping("veterinaire/nouveau")
    public Veterinaire createVeterinaires (@RequestBody Veterinaire vet) {

    return this.veterinaireDao.save(vet);



    }

    @RequestMapping(value="/modifie_veterinaire/",method=RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Veterinaire updateVeterinaire(@RequestBody Veterinaire veterinaire,Long id) {

        return veterinaireDao.save(veterinaire);

    }

//Supprime u animal
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("veterinaire/delete/{id}")
    public void  deleteVeterinaire(@PathVariable("id") Long id) {

    	veterinaireDao.deleteById(id);

    }*/

}

package com.dog.empire.controller;

import java.util.ArrayList;
import java.util.List;

import com.dog.empire.dao.EntrepriseDao;
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


import com.dog.empire.model.Entreprise;
import com.dog.empire.services.EntrepriseService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
@Component
@RestController
public class EntrepriseController {
	
	 @Autowired 
	 private EntrepriseService entrepriseService;
	@Autowired
	private EntrepriseDao entrepriseDao;
	 //creer une methode de recuperation de tous les animaux depuis la BD
		
		@GetMapping(value ="/entreprise/liste")
		public List<Entreprise> getAllEntreprises(){
			 List<Entreprise> liste= new ArrayList<>();
			 entrepriseService.fetchEntrepriseList().forEach(liste::add);
			return liste;
		}

	 // Save operation
	 @PostMapping("/entreprise/ajoute")

	 public Entreprise saveEntreprise(
	     @Validated @RequestBody Entreprise entreprise)
	 {
	     return entrepriseService.saveEntreprise(entreprise);
	 }
	 //
	 @RequestMapping(value="entreprise/{id}",method=RequestMethod.GET)
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 public Entreprise getEntrepriseById(@PathVariable("id") Long id) {

	     return entrepriseService.getEntrepriseById(id);
	 }

	 // tous les animaux
	 @GetMapping("/entreprises")

	 public List<Entreprise> fetchEntrepriseList()
	 {
	     return entrepriseService.fetchEntrepriseList();
	 }

	 // Update operation
	 @PutMapping("/entreprises/{id}")

	 public Entreprise updateEntreprise(@RequestBody Entreprise entreprise, @PathVariable("id") Long id)
	 {
	     return entrepriseService.updateEntreprise(
	    		 entreprise, id);
	 }

	 // Delete operation
	 @DeleteMapping("/entreprise/delete/{id}")

	 public String deleteEntrepriseById(@PathVariable("id") Long id)
	 {
		 entrepriseService.deleteEntrepriseById(id);
	     return "Deleted Successfully";
	 }

	/*@Autowired
	EntrepriseDao entrepriseDao;
    
	//liste de tous les veterinaires
	@GetMapping(value ="entreprise/liste")
	public List<Entreprise> getAllEntreprises(){
		 List<Entreprise> liste= new ArrayList<>();
		 entrepriseDao.findAll().forEach(liste::add);
		return liste;
	}

	 // Retourne un bailleur par son id 
    @RequestMapping(value="entreprise/{id}",method=RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Entreprise getEntrepriseById(@PathVariable("id") Long id) {

        return entrepriseDao.findById(id).get();
    }
    //Enregistre un nouvel animal
    @PostMapping("entreprise/nouveau")
    public Entreprise createVeterinaire (@RequestBody Entreprise vet) {

    return this.entrepriseDao.save(vet);



    }

    @RequestMapping(value="/modifie_entreprise/",method=RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Entreprise updateEntreprise(@RequestBody Entreprise entreprise,Long id) {

        return entrepriseDao.save(entreprise);

    }

//Supprime une entreprise
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("entreprise/delete/{id}")
    public void  deleteEntreprise(@PathVariable("id") Long id) {

    	entrepriseDao.deleteById(id);

    }*/

}

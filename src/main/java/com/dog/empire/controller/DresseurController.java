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


import com.dog.empire.model.Dresseur;

import com.dog.empire.services.DresseurService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/dresseur")
@Component
@RestController
public class DresseurController {
	 @Autowired 
	 private DresseurService dresseurService;
	 //creer une methode de recuperation de tous les animaux depuis la BD
		
		@GetMapping(value ="/liste")
		public List<Dresseur> getAllDresseurs(){
			 List<Dresseur> liste= new ArrayList<>();
			 dresseurService.fetchDresseurList().forEach(liste::add);
			return liste;
		}

	 // Save operation
	 @PostMapping("/ajout")

	 public Dresseur createDresseur(
	     @Validated @RequestBody Dresseur dresseur)
	 {
	     return dresseurService.saveDresseur(dresseur);
	 }
	 //
	 @RequestMapping(value="/{id}",method=RequestMethod.GET)
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 public Dresseur getDresseurById(@PathVariable("id") Long id) {

	     return dresseurService.getDresseurById(id);
	 }

	 // tous les animaux
	 @GetMapping("/dresseur")

	 public List<Dresseur> fetchDresseurList()
	 {
	     return dresseurService.fetchDresseurList();
	 }

	 // Update operation
	 @PutMapping("/modifie_dresseur/{id}")

	 public Dresseur updateDresseur(@RequestBody Dresseur dresseur, @PathVariable("id") Long iddresseur)
	 {
	     return dresseurService.updateDresseur(
	    		 dresseur, iddresseur);
	 }

	 // Delete operation
	 @DeleteMapping("/{id}")

	 public String deleteDresseurById(@PathVariable("id") Long iddresseur)
	 {
		 dresseurService.deleteDresseurById( iddresseur);
	     return "Deleted Successfully";
	 }
}

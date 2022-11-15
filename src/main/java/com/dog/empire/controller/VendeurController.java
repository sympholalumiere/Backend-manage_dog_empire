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

import com.dog.empire.model.Vendeur;

import com.dog.empire.services.VendeurService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
@Component
@RestController
public class VendeurController {
	 @Autowired 
	 private VendeurService vendeurService;
	 //creer une methode de recuperation de tous les animaux depuis la BD
		
		@GetMapping(value ="/vendeur/liste")
		public List<Vendeur> getAllVendeur(){
			 List<Vendeur> liste= new ArrayList<>();
			 vendeurService.fetchVendeurList().forEach(liste::add);
			return liste;
		}

	 // Save operation
	 @PostMapping("/ajoute/vendeur")

	 public Vendeur saveVendeur(
	     @Validated @RequestBody Vendeur vendeur)
	 {
	     return vendeurService.saveVendeur(vendeur);
	 }
	 //
	 @RequestMapping(value="vendeur/{id}",method=RequestMethod.GET)
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 public Vendeur getVendeurById(@PathVariable("id") Long id) {

	     return vendeurService.getVendeurById(id);
	 }

	 // tous les animaux
	 @GetMapping("/vendeur")

	 public List<Vendeur> fetchVendeurList()
	 {
	     return vendeurService.fetchVendeurList();
	 }

	 // Update operation
	 @PutMapping("/vendeur/{id}")

	 public Vendeur updateVendeur(@RequestBody Vendeur vendeur, @PathVariable("id") Long idvendeur)
	 {
	     return vendeurService.updateVendeur(
	    		 vendeur, idvendeur);
	 }

	 // Delete operation
	 @DeleteMapping("/vendeur/{id}")

	 public String deleteVendeurById(@PathVariable("id") Long idvendeur)
	 {
		 vendeurService.deleteVendeurById( idvendeur);
	     return "Deleted Successfully";
	 }


	

}

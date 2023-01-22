package com.dog.empire.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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

import com.dog.empire.model.Vente;
import com.dog.empire.services.VenteService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
@Component
@RestController
public class VenteController {
	 @Autowired
	 private VenteService venteService;
	 //creer une methode de recuperation de tous les animaux depuis la BD

		@GetMapping(value ="/vente/liste")
		public List<Vente> getAllVente(){
			 List<Vente> liste= new ArrayList<>();
			 venteService.fetchVenteList().forEach(liste::add);
			return liste;
		}

	 // Save operation
	 @PostMapping("/vente/ajoute")

	 public Vente saveVente(
	     @Validated @RequestBody Vente vente)
	 {
	     return venteService.saveVente(vente);
	 }
	 //
	 @RequestMapping(value="vente/{id}",method=RequestMethod.GET)
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 public Vente getVenteById(@PathVariable("id") Long id) {

	     return venteService.getVenteById(id);
	 }

	 // tous les animaux
	 @GetMapping("/ventes")

	 public List<Vente> fetchClientsList()
	 {
	     return venteService.fetchVenteList();
	 }

	 // Update operation
	 @PutMapping("/ventes/{id}")

	 public Vente updateVente(@RequestBody Vente vente, @PathVariable("id") Long idvente)
	 {
	     return venteService.updateVente(
	    		 vente, idvente);
	 }

	 // Delete operation
	 @DeleteMapping("/ventes/{id}")

	 public String deleteVenteById(@PathVariable("id") Long idvente)
	 {
		 venteService.deleteVenteById( idvente);
	     return "Deleted Successfully";
	 }

	@PutMapping(path = "/modifie_vente/{idVente}/assign/{userId}")
	public ResponseEntity<?> assignVenteToUser(
			@PathVariable Long idVente,
			@PathVariable Long userId
	) {
		venteService.assignVenteToUser(idVente, userId);
		return ResponseEntity.noContent().build();
	}

}

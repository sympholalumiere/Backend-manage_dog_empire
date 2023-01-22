package com.dog.empire.controller;

import java.util.ArrayList;
import java.util.List;

import com.dog.empire.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
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

import com.dog.empire.model.Achat;
import com.dog.empire.services.AchatService;

import javax.servlet.http.HttpSession;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/achats")
@Component
@RestController
public class AchatController {
	@Autowired
	private AchatService achatService;
	//creer une methode de recuperation de tous les animaux depuis la BD

	@GetMapping(value = "/liste")
	public List<Achat> getAllAchats() {
		List<Achat> liste = new ArrayList<>();
		achatService.fetchAchatList().forEach(liste::add);
		return liste;
	}

	@GetMapping(value = "/totalAchat")
	public Long getAchatByprixTotal() {
		return achatService.getAchatByprixTotal();
	}

	// Save operation

	@PostMapping("/ajout")
	public Achat createAchat(
			@Validated @RequestBody Achat achat) {
		return achatService.saveAchat(achat);
	}

	//
	@RequestMapping(value = "/achats/{id}", method = RequestMethod.GET)
	@CrossOrigin(origins = "*", allowedHeaders = "*")
	public Achat getAchatById(@PathVariable("id") Long id) {

		return achatService.getAchatById(id);
	}

	// tous les animaux
	@GetMapping("/achats")

	public List<Achat> fetchAchatList() {
		return achatService.fetchAchatList();
	}

	// Update operation
	@PutMapping("/modifie_achat/{id}")

	public Achat updateAchat(@RequestBody Achat achat, @PathVariable("id") Long idachat) {
		return achatService.updateAchat(
				achat, idachat);
	}

	// Delete operation
	@DeleteMapping("/delete/{id}")

	public String deleteAchatById(@PathVariable("id") Long idachat) {
		achatService.deleteAchatById(idachat);
		return "Deleted Successfully";
	}

	@PutMapping(path = "/assign_achat/{idAchat}/user/{userId}")
	public ResponseEntity<?> assignAchatToUser(
			@PathVariable Long idAchat,
			@PathVariable Long userId
	) {
		achatService.assignAchatToUser(idAchat, userId);
		return ResponseEntity.noContent().build();
	}

	//recuperer tout les achat d'un user
	@GetMapping("/user/{userId}")
	public List<Achat> fetchAchatListUser(@RequestBody Achat achat, @PathVariable("userId") Long userId) {
		return achatService.fetchAchatListByUser(userId);
	}

}


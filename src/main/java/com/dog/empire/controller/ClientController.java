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

import com.dog.empire.model.Clients;
import com.dog.empire.services.ClientService;



@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
@Component
@RestController
public class ClientController {
	 @Autowired 
	 private ClientService clientService;
	 //creer une methode de recuperation de tous les animaux depuis la BD
		
		@GetMapping(value ="/client/liste")
		public List<Clients> getAllClients(){
			 List<Clients> liste= new ArrayList<>();
			 clientService.fetchClientsList().forEach(liste::add);
			return liste;
		}

	// Save operation
	@PostMapping("/client/ajoute")

	public Clients saveClients(
			@Validated @RequestBody Clients clients)
	{
		return clientService.saveClients(clients);
	}
	 //
	 @RequestMapping(value="client/{id}",method=RequestMethod.GET)
	 @CrossOrigin(origins = "*", allowedHeaders = "*")
	 public Clients getClientById(@PathVariable("id") Long id) {

	     return clientService.getClientsById(id);
	 }

	 // tous les animaux
	 @GetMapping("/clients")

	 public List<Clients> fetchClientsList()
	 {
	     return clientService.fetchClientsList();
	 }

	 // Update operation
	 @PutMapping("/clients/{id}")

	 public Clients updateClient(@RequestBody Clients client, @PathVariable("id") Long idclient)
	 {
	     return clientService.updateClients(
	    		 client, idclient);
	 }

	 // Delete operation
	 @DeleteMapping("/clients/{id}")

	 public String deleteClientById(@PathVariable("id") Long idclient)
	 {
		 clientService.deleteClientsById( idclient);
	     return "Deleted Successfully";
	 }


}

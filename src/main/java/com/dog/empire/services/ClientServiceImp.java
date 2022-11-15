package com.dog.empire.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.dog.empire.dao.ClientDao;
import com.dog.empire.exception.ClientNotFoundException;

import com.dog.empire.model.Clients;



@Component
@Service
public class ClientServiceImp implements ClientService{
	//Annotation
		 @Autowired
		 private ClientDao clientDao;


	@Override
	public Clients saveClients(Clients clients) {
		// ici j'enregistre un nouveau client
		return clientDao.save(clients);
	}

	@Override
	//Recup par l'id
	public Clients getClientsById(Long id) {
		Optional<Clients> opt = clientDao.findById(id);
	    if(opt.isPresent()) {
	        return opt.get();
	    } else {
	        throw new ClientNotFoundException("le client avec id : "+id+" n'exixte pas");
	    }
	}

	@Override
	public List<Clients> fetchClientsList() {
		// ici l'affiche la liste des clients
		return (List<Clients>)clientDao.findAll();
	}

	@Override
	public List<Clients> getAllClients() {
		// TODO Auto-generated method stub
		return null;
	}

	//modifier client
	@Override
	public Clients updateClients(Clients veterinaire, Long idclient) {
		Clients ClientsDB = clientDao.findById(idclient).get();
		 return clientDao.save(ClientsDB);
	}

	//Supprimer client
	@Override
	public void deleteClientsById(Long idclient) {
		clientDao.deleteById(idclient);
		
	}

}

package com.dog.empire.services;

import java.util.List;

import com.dog.empire.model.Animal;

public interface AnimalService {
	    // Save operation
	    Animal saveAnimal(Animal animal);
	    
	    //get by id
	    public Animal getAnimalById(Long id);
	    
	
	 
	    // Read operation
	    List<Animal> fetchAnimalList();
	    public List<Animal> getAllAnimals();
	 
	    // Update operation
	    Animal updateAnimal(Animal animal, Long idanimal);
	 
	    // Delete operation
	    void deleteAnimalById(Long idanimal);

		
	    

}

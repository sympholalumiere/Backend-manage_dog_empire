package com.dog.empire.controller;

import java.util.ArrayList;
//import java.util.ArrayList;
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


//import com.dog.empire.dao.AnimalDao;
import com.dog.empire.model.Animal;
import com.dog.empire.services.AnimalService;
//import com.dog.empire.services.AnimalServiceImp;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/api/dogempire/")
	//Annotation
@Component
@RestController
//Class
public class AnimalController {

 @Autowired 
 private AnimalService animalService;
 //creer une methode de recuperation de tous les animaux depuis la BD
	
	@GetMapping(value ="animal/liste")
	public List<Animal> getAllAnimals(){
		 List<Animal> liste= new ArrayList<>();
		 animalService.fetchAnimalList().forEach(liste::add);
		return liste;
	}

 // Save operation
 @PostMapping("animal/ajout")

 public Animal createAnimal(
     @Validated @RequestBody Animal animal)
 {
     return animalService.saveAnimal(animal);
 }
 //
 @RequestMapping(value="animal/{id}",method=RequestMethod.GET)
 @CrossOrigin(origins = "*", allowedHeaders = "*")
 public Animal getAnimalById(@PathVariable("id") Long id) {

     return animalService.getAnimalById(id);
 }

 // tous les animaux
 @GetMapping("animal/animals")

 public List<Animal> fetchAnimalList()
 {
     return animalService.fetchAnimalList();
 }

 // Update operation
 @PutMapping("animal/modifie_animal/{id}")

 public Animal updateAnimal(@RequestBody Animal animal, @PathVariable("id") Long idanimal)
 {
     return animalService.updateAnimal(
    		 animal, idanimal);
 }

 // Delete operation
 @DeleteMapping("animal/{id}")

 public String deleteAnimalById(@PathVariable("id") Long idanimal)
 {
	 animalService.deleteAnimalById( idanimal);
     return "Deleted Successfully";
 }
}
/*
@RestController
public class AnimalController {
	
	//AnimalServiceImp animalService;
	@Autowired
	AnimalDao animalDao;
    //creer une methode de recuperation de tous les animaux depuis la BD
	//liste de tous les bailleurs
	@GetMapping(value ="animaux/liste")
	public List<Animal> getAllAnimals(){
		 List<Animal> liste= new ArrayList<>();
		 animalDao.findAll().forEach(liste::add);
		return liste;
	}
	
    //creer une methode de suppression d'un animal par son id depuis la BD
    @DeleteMapping("/animal/{id}")
    private void deleteBook(@PathVariable("id") Long id)
    {
        animalService.delete(id);
    }
    //creer une methode d'enregistrement d'un animal par son id depuis la BD
    @PostMapping("/animal")
    private Long saveAnimal(@RequestBody Animal animal)
    {
        animalService.saveOrUpdate(animal);
        return animal.getId();
    }

    @PutMapping("/books")
    private Animal update(@RequestBody Animal animal)
    {
        animalService.saveOrUpdate(animal);
        return animal;
    }

	 // Retourne un bailleur par son id 
    @RequestMapping(value="animal/{id}",method=RequestMethod.GET)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Animal getAnimalById(@PathVariable("id") Long id) {

        return animalDao.findById(id).get();
    }
    //Enregistre un nouvel animal
    @PostMapping("animal/nouveau")
    public Animal createAnimal (@RequestBody Animal dog) {

    return this.animalDao.save(dog);



    }

    @RequestMapping(value="/modifie_animal/",method=RequestMethod.PUT)
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    public Animal updateAnimal(@RequestBody Animal animal,Long id) {

        return animalDao.save(animal);

    }

//Supprime u animal
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("animal/delete/{id}")
    public void  deleteBailleur(@PathVariable("id") Long id) {

    	animalDao.deleteById(id);

    }


}
*/

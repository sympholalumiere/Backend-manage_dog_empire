package com.dog.empire.services;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;




//import org.springframework.beans.factory.annotation.Autowired;

import com.dog.empire.dao.AnimalDao;
import com.dog.empire.exception.AnimalNotFoundException;
import com.dog.empire.model.Animal;
@Component
@Service
 public class AnimalServiceImp implements AnimalService  {
	/*
	    AnimalDao animalDao;
	    // Recupère tout les animaux
	    public List<Animal> getAllAnimals(){
			 List<Animal> liste= new ArrayList<>();
			 animalDao.findAll().forEach(liste::add);
			return liste;
		}
	 
	 // Retourne un bailleur par son id 
	    @RequestMapping(value="/{id}",method=RequestMethod.GET)
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    public Animal getAnimalById(@PathVariable("id") Long id) {

	        return animalDao.findById(id).get();
	    }
	    //Enregistre un nouvel animal
	    @PostMapping("/nouveau")
	    public Animal createAnimal (@RequestBody Animal dog) {

	    return this.animalDao.save(dog);



	    }

	    @RequestMapping(value="/modifie_bail/",method=RequestMethod.PUT)
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    public Animal updateAnimal(@RequestBody Animal animal,Long id) {

	        return animalDao.save(animal);

	    }

// Supprime u animal
	    @CrossOrigin(origins = "*", allowedHeaders = "*")
	    @DeleteMapping("/delete/{id}")
	    public void  deleteBailleur(@PathVariable("id") Long id) {

	    	animalDao.deleteById(id);

	    }

}*/

//Annotation
 @Autowired
 private AnimalDao animalDao;

 // Save operation
 @Override
 public Animal saveAnimal(Animal animal)
 {
     return animalDao.save(animal);
 }


 // Read operation
 @Override public List<Animal> fetchAnimalList()
 {
     return (List<Animal>)
    		 animalDao.findAll();
 }
 // recuperer par son id
 @Override
 public Animal getAnimalById(Long id) {
    Optional<Animal> opt = animalDao.findById(id);
    if(opt.isPresent()) {
        return opt.get();
    } else {
        throw new AnimalNotFoundException("Animal avec id : "+id+" n'exixte pas");
    }
 }

 // Update operation
 @Override
 public Animal
 updateAnimal(Animal animal, Long idanimal)
 {

	 Animal animalDB
         = animalDao.findById(idanimal).get();

    /* if (Objects.nonNull(department.getDepartmentName())
         && !"".equalsIgnoreCase(
             department.getDepartmentName())) {
         depDB.setDepartmentName(
             department.getDepartmentName());
     }

     if (Objects.nonNull(
             department.getDepartmentAddress())
         && !"".equalsIgnoreCase(
             department.getDepartmentAddress())) {
         depDB.setDepartmentAddress(
             department.getDepartmentAddress());
     }

     if (Objects.nonNull(department.getDepartmentCode())
         && !"".equalsIgnoreCase(
             department.getDepartmentCode())) {
         depDB.setDepartmentCode(
             department.getDepartmentCode());
     }
*/
     return animalDao.save(animalDB);
 }

 // Delete operation
 @Override
 public void deleteAnimalById(Long idanimal)
 {
	 animalDao.deleteById(idanimal);
 }


@Override
public List<Animal> getAllAnimals() {
	// TODO Auto-generated method stub
	return null;
}
}



 

 


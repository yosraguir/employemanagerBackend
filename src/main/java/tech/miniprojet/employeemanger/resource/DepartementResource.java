package tech.miniprojet.employeemanger.resource;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import tech.miniprojet.employeemanger.Model.Departement;
import tech.miniprojet.employeemanger.Model.Employee;
import tech.miniprojet.employeemanger.Repository.DepartementRepo;
import tech.miniprojet.employeemanger.Service.DepartementService;

@RestController
@RequestMapping("/departement")
public class DepartementResource {
	@Autowired 
	DepartementRepo repo;
	@Autowired
	DepartementRepo departementreo;
	@Autowired
private DepartementService departementService ; 
	
@GetMapping("/all")
public ResponseEntity<List<Departement>> getAllDepartement() {
	List<Departement> departements = departementService.findAlldepartement();
	return new ResponseEntity<>(departements, HttpStatus.OK);
	
}



@PostMapping("/add")
public ResponseEntity<Departement> addDepartement(@RequestBody Departement departement ){
	System.out.print(departement); 
	this.repo.save(departement);

return null;
}

@PutMapping("/update")
public ResponseEntity<Departement> updateDepartement(@RequestBody Departement departement){
	Departement updateDepartement = departementService.update(departement);	
	return new ResponseEntity<>(updateDepartement, HttpStatus.OK);
	
}

@DeleteMapping("/delete/{id}")
public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id){
	
	Departement departement = departementreo.findDepartementById(id);
	departementreo.delete(departement);
	return new ResponseEntity<>(HttpStatus.OK);
	

}


}

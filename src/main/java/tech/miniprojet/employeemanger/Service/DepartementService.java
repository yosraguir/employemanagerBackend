package tech.miniprojet.employeemanger.Service;



import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.miniprojet.employeemanger.Model.Departement;
import tech.miniprojet.employeemanger.Model.Employee;
import tech.miniprojet.employeemanger.Repository.DepartementRepo;
import tech.miniprojet.employeemanger.exception.UserNotFoundException;

@Service
public class DepartementService {

	@Autowired
	private DepartementRepo departementRepo;
	
	public Departement addDempartement(Departement dempartement ) {
		
		return departementRepo.save(dempartement);	
	}
	

	public List<Departement> findAlldepartement(){
		return departementRepo.findAll();
	}
	
	public Departement update(Departement departement) {
		return departementRepo.save(departement);
	}
	
	public Departement findDepartementById(Long id) {
        return departementRepo.findById(id).get();
        		
    }
	public void deleteDepartement(Long id ) {
		departementRepo.deleteDepartementById(id);
	}
	
	
	
}

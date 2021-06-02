package tech.miniprojet.employeemanger.Service;

import java.util.List;
import java.util.UUID;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tech.miniprojet.employeemanger.Model.Departement;
import tech.miniprojet.employeemanger.Model.Employee;
import tech.miniprojet.employeemanger.Repository.DepartementRepo;
import tech.miniprojet.employeemanger.Repository.EmployeeRepo;
import tech.miniprojet.employeemanger.exception.UserNotFoundException;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepo employeeRepo;
	

	@Autowired
    private DepartementRepo departementRepo;
	
	@Autowired
	public EmployeeService (EmployeeRepo employeeRepo) {
		this.employeeRepo = employeeRepo ;
	}
	
	public Employee addEmployee(Employee employee , Long id  ) {
		Departement d = departementRepo.findById(id).get();
		employee.setEmployeeCode(UUID.randomUUID().toString());
		employee.setDepartement(d);
		return employeeRepo.save(employee);	
	}
	

	
	
	public List<Employee> findAllEmployeees(){
		return employeeRepo.findAll();
	}
	
	public Employee updateEmployee(Employee employee ) {
		return employeeRepo.save(employee);
	}
	
	 public Employee findEmployeeById(Long id) {
	        return employeeRepo.findById(id)
	        		.orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
	    }
	
	public void deleteEmployee(Long id ) {
		employeeRepo.deleteEmployeeById(id);
	}
	

}

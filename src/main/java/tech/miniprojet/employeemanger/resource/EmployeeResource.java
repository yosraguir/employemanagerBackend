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

import tech.miniprojet.employeemanger.Model.Employee;
import tech.miniprojet.employeemanger.Repository.EmployeeRepo;
import tech.miniprojet.employeemanger.Service.EmployeeService;

@RestController
@RequestMapping("/employee")
public class EmployeeResource  {
	@Autowired
	private  EmployeeRepo employeeRepo;
	
	@Autowired
	private final EmployeeService employeeService;
	
	public EmployeeResource(EmployeeService employeeService,EmployeeRepo employeeRepo) {
		
	this.employeeService =employeeService;
	this.employeeRepo= employeeRepo;
	}
	
	@GetMapping("/all")
	public ResponseEntity<List<Employee>> getAllEmployees() {
		List<Employee> employees = employeeService.findAllEmployeees();
		return new ResponseEntity<>(employees, HttpStatus.OK);
		
	}
	
	@GetMapping("/find/{id}")
	
	public ResponseEntity<Employee> getEmployeeById (@PathVariable("id") Long id ){
		Employee employee = employeeService.findEmployeeById(id);
		return new ResponseEntity<>(employee, HttpStatus.OK);
	}
	
    @PostMapping("/add/{id}")
	public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee,@PathVariable("id") Long id ){
    	Employee newEmployee = employeeService.addEmployee(employee,id);
    	return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    	
	}
    
    
    @PutMapping("/update")
	public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee){
    	Employee  updateEmployee = employeeService.updateEmployee(employee);	
    	return new ResponseEntity<>( updateEmployee, HttpStatus.OK);
    	
	}
    
    @DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteEmployee(@PathVariable(value = "id") Long id){
    	//employeeService.deleteEmployee(id);	
    	Employee employee = employeeRepo.findEmployeeById(id);
    	employeeRepo.delete(employee);
    	//employeeRepo.deleteEmployeeById(id);
    	return new ResponseEntity<>(HttpStatus.OK);
    	

	}
    
    

}

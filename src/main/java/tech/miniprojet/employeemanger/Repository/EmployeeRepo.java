package tech.miniprojet.employeemanger.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.miniprojet.employeemanger.Model.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

	void deleteEmployeeById(Long id);

	
	Employee findEmployeeById(Long id);
	
	Optional<Employee> findById(Long id);
}

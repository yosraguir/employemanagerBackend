package tech.miniprojet.employeemanger.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tech.miniprojet.employeemanger.Model.Departement;
import tech.miniprojet.employeemanger.Model.Employee;

@Repository
public interface DepartementRepo extends JpaRepository<Departement, Long> {

	Departement findByName(String name );
    Departement getById(Long id);
    //Optional<Departement> findById(Long id);
    void deleteDepartementById(Long id);
    Departement findDepartementById(Long id);

}

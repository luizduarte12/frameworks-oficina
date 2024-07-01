package br.ufac.webacademy.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.webacademy.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{
    
    
} 
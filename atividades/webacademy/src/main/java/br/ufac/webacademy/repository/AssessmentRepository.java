package br.ufac.webacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.webacademy.models.Assessment;

public interface AssessmentRepository extends JpaRepository<Assessment, Long>{
    
}

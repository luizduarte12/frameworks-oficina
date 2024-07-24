package br.ufac.webacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.webacademy.models.Classes;

public interface ClassesRepository extends JpaRepository<Classes, Long> {
    
}

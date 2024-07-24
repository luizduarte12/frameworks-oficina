package br.ufac.webacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.webacademy.models.Class;

public interface ClassRepository extends JpaRepository<Class, Long> {
    
}

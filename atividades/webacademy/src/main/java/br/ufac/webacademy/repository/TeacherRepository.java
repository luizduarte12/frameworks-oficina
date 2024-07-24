package br.ufac.webacademy.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.webacademy.models.Teacher;

public interface TeacherRepository extends JpaRepository<Teacher, Long>{
    
}

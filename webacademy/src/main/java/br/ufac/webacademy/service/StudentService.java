package br.ufac.webacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.webacademy.models.Student;
import br.ufac.webacademy.repository.StudentRepository;

@Service
public class StudentService implements IService<Student>{

    private StudentRepository repo;

    public StudentService(StudentRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Student> get() {
        return repo.findAll();
    }

    @Override
    public Student get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Student save(Student objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }

}

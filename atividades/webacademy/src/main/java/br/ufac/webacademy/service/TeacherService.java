package br.ufac.webacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.webacademy.models.Teacher;
import br.ufac.webacademy.repository.TeacherRepository;

@Service
public class TeacherService implements IService<Teacher>{

    private TeacherRepository repo;

    public TeacherService(TeacherRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Teacher> get() {
        return repo.findAll();
    }

    @Override
    public Teacher get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Teacher save(Teacher objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}

package br.ufac.webacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.webacademy.models.Classes;
import br.ufac.webacademy.repository.ClassesRepository;

@Service
public class ClassesService implements IService<Classes>{

    private ClassesRepository repo;

    public ClassesService(ClassesRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Classes> get() {
        return repo.findAll();
    }

    @Override
    public Classes get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Classes save(Classes objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}

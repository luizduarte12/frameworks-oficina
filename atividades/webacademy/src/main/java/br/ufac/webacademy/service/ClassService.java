package br.ufac.webacademy.service;
import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.webacademy.models.Class;
import br.ufac.webacademy.repository.ClassRepository;

@Service
public class ClassService implements IService<Class>{

    private ClassRepository repo;

    public ClassService(ClassRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Class> get() {
        return repo.findAll();
    }

    @Override
    public Class get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Class save(Class objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}

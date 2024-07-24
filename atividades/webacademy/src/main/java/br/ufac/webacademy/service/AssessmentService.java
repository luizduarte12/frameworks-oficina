package br.ufac.webacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.webacademy.models.Assessment;
import br.ufac.webacademy.repository.AssessmentRepository;

@Service
public class AssessmentService implements IService<Assessment>{

    private AssessmentRepository repo;

    public AssessmentService(AssessmentRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Assessment> get() {
        return repo.findAll();
    }

    @Override
    public Assessment get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Assessment save(Assessment objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}

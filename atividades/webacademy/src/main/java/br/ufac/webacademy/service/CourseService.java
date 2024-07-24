package br.ufac.webacademy.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.webacademy.models.Course;
import br.ufac.webacademy.repository.CourseRepository;

@Service
public class CourseService implements IService<Course>{

    private CourseRepository repo;

    public CourseService(CourseRepository repo){
        this.repo = repo;
    }

    @Override
    public List<Course> get() {
        return repo.findAll();
    }

    @Override
    public Course get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Course save(Course objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
        repo.deleteById(id);
    }
    
}

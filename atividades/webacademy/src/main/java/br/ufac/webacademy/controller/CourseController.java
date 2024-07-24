package br.ufac.webacademy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import br.ufac.webacademy.models.Course;
import br.ufac.webacademy.service.CourseService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/course")
public class CourseController implements IController<Course> {

    private CourseService service;

    public CourseController(CourseService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Course>> get() {
        List<Course> registros = service.get();
        return ResponseEntity.ok(registros);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Course> get(@PathVariable("id") Long id) {
        Course registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Course> insert(@RequestBody Course objeto) {
        Course registro = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Course> update(@RequestBody Course objeto) {
        Course registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
}

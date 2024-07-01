package br.ufac.webacademy.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.webacademy.models.Student;
import br.ufac.webacademy.service.StudentService;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/student")
public class StudentController implements IController<Student>{

    private StudentService service;

    public StudentController(StudentService service) {
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Student>> get() {
        List<Student> registros = service.get();
        return ResponseEntity.ok(registros);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Student> get(@PathVariable("id") Long id) {
        Student registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Student> insert(@RequestBody Student objeto) {
        Student registro = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Student> update(@RequestBody Student objeto) {
        Student registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

}

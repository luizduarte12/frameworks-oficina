package br.ufac.webacademy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.ufac.webacademy.models.Teacher;
import br.ufac.webacademy.service.TeacherService;

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
@RequestMapping("/teacher")
public class TeacherController implements IController<Teacher>{

    private TeacherService service;

    public TeacherController(TeacherService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Teacher>> get() {
        List<Teacher> registros = service.get();
        return ResponseEntity.ok(registros);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Teacher> get(@PathVariable("id") Long id) {
        Teacher registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Teacher> insert(@RequestBody Teacher objeto) {
        Teacher registro = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Teacher> update(@RequestBody Teacher objeto) {
        Teacher registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
}

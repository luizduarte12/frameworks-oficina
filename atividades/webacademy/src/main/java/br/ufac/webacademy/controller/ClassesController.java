package br.ufac.webacademy.controller;

import br.ufac.webacademy.models.Classes;
import br.ufac.webacademy.service.ClassesService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/classes")
public class ClassesController implements IController<Classes>{

    private ClassesService service;

    public ClassesController(ClassesService service){
        this.service = service;
    }
    @Override
    @GetMapping("/")
    public ResponseEntity<List<Classes>> get() {
        List<Classes> registros = service.get();
        return ResponseEntity.ok(registros);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Classes> get(@PathVariable("id") Long id) {
        Classes registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Classes> insert(@RequestBody Classes objeto) {
        Classes registro = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Classes> update(@RequestBody Classes objeto) {
        Classes registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }

    
}

package br.ufac.webacademy.controller;
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

import br.ufac.webacademy.models.Class;
import br.ufac.webacademy.service.ClassService;


@RestController
@RequestMapping("/class")
public class ClassController implements IController<Class>{

    private ClassService service;

    private ClassController(ClassService service){
        this.service = service;
        
    }


    @Override
    @GetMapping("/")
    public ResponseEntity<List<Class>> get() {
        List<Class> registros = service.get();
        return ResponseEntity.ok(registros);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Class> get(@PathVariable("id") Long id) {
        Class registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Class> insert(@RequestBody Class objeto) {
        Class registro = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Class> update(@RequestBody Class objeto) {
        Class registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
}

package br.ufac.webacademy.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import br.ufac.webacademy.models.Assessment;
import br.ufac.webacademy.service.AssessmentService;

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
@RequestMapping("/assessement")
public class AssessementController implements IController<Assessment>{

    private AssessmentService service;

    public AssessementController(AssessmentService service){
        this.service = service;
    }

    @Override
    @GetMapping("/")
    public ResponseEntity<List<Assessment>> get() {
        List<Assessment> registros = service.get();
        return ResponseEntity.ok(registros);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Assessment> get(@PathVariable("id") Long id) {
        Assessment registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Assessment> insert(@RequestBody Assessment objeto) {
        Assessment registro = service.save(objeto);
        return ResponseEntity.status(HttpStatus.CREATED).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Assessment> update(@RequestBody Assessment objeto) {
        Assessment registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body(null);
    }
    
}

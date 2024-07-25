package br.ufac.login.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.ufac.login.models.Usuario;
import br.ufac.login.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController implements IController<Usuario>{

    private UsuarioService service;

    public UsuarioController(UsuarioService service) {
        this.service = service;
    }
    @Override
    @GetMapping("/")
    public ResponseEntity<List<Usuario>> get() {
        List<Usuario> registro = service.get();
        return ResponseEntity.ok(registro);
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> get(@PathVariable("id") Long id) {
        Usuario registro = service.get(id);
        return ResponseEntity.ok(registro);
    }

    @Override
    @PostMapping("/")
    public ResponseEntity<Usuario> insert(@RequestBody Usuario objeto) {
        Usuario registro = service.save(objeto);
        return ResponseEntity.status(201).body(registro);
    }

    @Override
    @PutMapping("/")
    public ResponseEntity<Usuario> update(@RequestBody Usuario objeto) {
        Usuario registro = service.save(objeto);
        return ResponseEntity.ok(registro);
    }

    @Override
    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> delete(@PathVariable("id") Long id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }
    
}

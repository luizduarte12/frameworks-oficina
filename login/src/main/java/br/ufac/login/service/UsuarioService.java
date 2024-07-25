package br.ufac.login.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.ufac.login.models.Usuario;
import br.ufac.login.repository.UsuarioRepository;

@Service
public class UsuarioService implements IService<Usuario>{

    private UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<Usuario> get() {
        return repo.findAll();
    }

    @Override
    public Usuario get(Long id) {
        return repo.findById(id).orElse(null);
    }

    @Override
    public Usuario save(Usuario objeto) {
        return repo.save(objeto);
    }

    @Override
    public void delete(Long id) {
       repo.deleteById(id);
    }

}

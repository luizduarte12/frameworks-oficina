package br.ufac.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufac.login.models.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}

package br.ufac.login.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

public interface IController<T> {
    public ResponseEntity<List<T>> get();
    public ResponseEntity<T> get(Long id);
    public ResponseEntity<T> insert(T objeto);
    public ResponseEntity<T> update(T objeto);
    public ResponseEntity<?> delete(Long id);
}

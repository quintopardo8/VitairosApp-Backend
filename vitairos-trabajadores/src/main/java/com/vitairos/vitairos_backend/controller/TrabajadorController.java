package com.vitairos.vitairos_backend.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.vitairos.vitairos_backend.model.Trabajador;
import com.vitairos.vitairos_backend.repository.TrabajadorRepository;

@RestController
@RequestMapping("/api/trabajadores")
@CrossOrigin(origins = "*")
public class TrabajadorController {

    private final TrabajadorRepository repository;

    public TrabajadorController(TrabajadorRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Trabajador> listar() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Trabajador> obtenerPorId(@PathVariable Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Trabajador crear(@RequestBody Trabajador trabajador) {
        trabajador.setId(null); 
        if (trabajador.getAreaAsignada() == null) {
            trabajador.setAreaAsignada("");
        }
        return repository.save(trabajador);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Trabajador> actualizar(
            @PathVariable Long id,
            @RequestBody Trabajador datos
    ) {
        return repository.findById(id).map(existente -> {
            existente.setNombre(datos.getNombre());
            existente.setCargo(datos.getCargo());
            existente.setAreaAsignada(datos.getAreaAsignada() != null ? datos.getAreaAsignada() : "");
            return ResponseEntity.ok(repository.save(existente));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
package com.vitairos.vitairos_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitairos.vitairos_backend.model.Trabajador;

public interface TrabajadorRepository extends JpaRepository<Trabajador, Long> {
}
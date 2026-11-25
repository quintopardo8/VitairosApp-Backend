package com.vitairos.vitairos_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.vitairos.vitairos_backend.model.Reporte;

public interface ReporteRepository extends JpaRepository<Reporte, String> {
}
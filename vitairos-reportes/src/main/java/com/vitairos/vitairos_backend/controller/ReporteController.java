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
import org.springframework.web.bind.annotation.RestController;

import com.vitairos.vitairos_backend.dto.GeoJsonPointDto;
import com.vitairos.vitairos_backend.dto.ReporteRequestDto;
import com.vitairos.vitairos_backend.model.Reporte;
import com.vitairos.vitairos_backend.repository.ReporteRepository;

@RestController
@RequestMapping("/api/reportes")
@CrossOrigin(origins = "*")
public class ReporteController {

    private final ReporteRepository repository;

    public ReporteController(ReporteRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<ReporteRequestDto> listar() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReporteRequestDto> obtenerPorId(@PathVariable String id) {
        return repository.findById(id)
                .map(r -> ResponseEntity.ok(toDto(r)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> crear(@RequestBody ReporteRequestDto dto) {
        if (esBlanco(dto.getId()) || esBlanco(dto.getTipoReporte()) || esBlanco(dto.getProcesoAsociado())) {
            return ResponseEntity.badRequest()
                    .body("Los campos id, tipoReporte y procesoAsociado son obligatorios");
        }
        Reporte entity = toEntity(dto);
        if (esBlanco(entity.getEstado())) {
            entity.setEstado("Sincronizado");
        }
        Reporte guardado = repository.save(entity);
        return ResponseEntity.status(HttpStatus.CREATED).body(toDto(guardado));
    }

    private boolean esBlanco(String valor) {
        return valor == null || valor.trim().isEmpty();
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<ReporteRequestDto> actualizar(
            @PathVariable String id,
            @RequestBody ReporteRequestDto dto
    ) {
        return repository.findById(id).map(existente -> {
            Reporte actualizado = toEntity(dto);
            actualizado.setId(id);
            return ResponseEntity.ok(toDto(repository.save(actualizado)));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable String id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    private Reporte toEntity(ReporteRequestDto dto) {
        Reporte r = new Reporte();
        r.setId(dto.getId());
        r.setTipoReporte(dto.getTipoReporte());
        r.setProcesoAsociado(dto.getProcesoAsociado());
        r.setFechaHora(dto.getFechaHora());
        r.setUsuario(dto.getUsuario());
        r.setAreaFaena(dto.getAreaFaena());
        r.setTurno(dto.getTurno());
        r.setObservaciones(dto.getObservaciones());
        r.setRutaArchivoLocal(dto.getRutaArchivoLocal());
        r.setEstado(dto.getEstado());
        r.setAltitud(dto.getAltitud());

        if (dto.getUbicacion() != null && dto.getUbicacion().getCoordinates() != null
                && dto.getUbicacion().getCoordinates().size() >= 2) {
            r.setLongitud(dto.getUbicacion().getCoordinates().get(0));
            r.setLatitud(dto.getUbicacion().getCoordinates().get(1));
        }
        return r;
    }

    private ReporteRequestDto toDto(Reporte r) {
        ReporteRequestDto dto = new ReporteRequestDto();
        dto.setId(r.getId());
        dto.setTipoReporte(r.getTipoReporte());
        dto.setProcesoAsociado(r.getProcesoAsociado());
        dto.setFechaHora(r.getFechaHora());
        dto.setUsuario(r.getUsuario());
        dto.setAreaFaena(r.getAreaFaena());
        dto.setTurno(r.getTurno());
        dto.setObservaciones(r.getObservaciones());
        dto.setRutaArchivoLocal(r.getRutaArchivoLocal());
        dto.setEstado(r.getEstado());
        dto.setAltitud(r.getAltitud());

        if (r.getLongitud() != null && r.getLatitud() != null) {
            dto.setUbicacion(new GeoJsonPointDto("Point", List.of(r.getLongitud(), r.getLatitud())));
        }
        return dto;
    }
}
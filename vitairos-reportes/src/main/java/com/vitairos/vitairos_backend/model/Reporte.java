package com.vitairos.vitairos_backend.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "reportes")
public class Reporte {

    @Id
    private String id;

    private String tipoReporte;
    private String procesoAsociado;
    private String fechaHora;
    private String usuario;
    private String areaFaena;
    private String turno;

    @Column(length = 500)
    private String observaciones;

    private String rutaArchivoLocal;
    private String estado;

    private Double longitud;
    private Double latitud;
    private Double altitud;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTipoReporte() { return tipoReporte; }
    public void setTipoReporte(String tipoReporte) { this.tipoReporte = tipoReporte; }

    public String getProcesoAsociado() { return procesoAsociado; }
    public void setProcesoAsociado(String procesoAsociado) { this.procesoAsociado = procesoAsociado; }

    public String getFechaHora() { return fechaHora; }
    public void setFechaHora(String fechaHora) { this.fechaHora = fechaHora; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) { this.usuario = usuario; }

    public String getAreaFaena() { return areaFaena; }
    public void setAreaFaena(String areaFaena) { this.areaFaena = areaFaena; }

    public String getTurno() { return turno; }
    public void setTurno(String turno) { this.turno = turno; }

    public String getObservaciones() { return observaciones; }
    public void setObservaciones(String observaciones) { this.observaciones = observaciones; }

    public String getRutaArchivoLocal() { return rutaArchivoLocal; }
    public void setRutaArchivoLocal(String rutaArchivoLocal) { this.rutaArchivoLocal = rutaArchivoLocal; }

    public String getEstado() { return estado; }
    public void setEstado(String estado) { this.estado = estado; }

    public Double getLongitud() { return longitud; }
    public void setLongitud(Double longitud) { this.longitud = longitud; }

    public Double getLatitud() { return latitud; }
    public void setLatitud(Double latitud) { this.latitud = latitud; }

    public Double getAltitud() { return altitud; }
    public void setAltitud(Double altitud) { this.altitud = altitud; }
}
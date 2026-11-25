package com.vitairos.vitairos_backend.dto;

public class ReporteRequestDto {
    private String id;
    private String tipoReporte;
    private String procesoAsociado;
    private String fechaHora;
    private String usuario;
    private String areaFaena;
    private String turno;
    private String observaciones;
    private String rutaArchivoLocal;
    private String estado;
    private GeoJsonPointDto ubicacion;
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

    public GeoJsonPointDto getUbicacion() { return ubicacion; }
    public void setUbicacion(GeoJsonPointDto ubicacion) { this.ubicacion = ubicacion; }

    public Double getAltitud() { return altitud; }
    public void setAltitud(Double altitud) { this.altitud = altitud; }
}
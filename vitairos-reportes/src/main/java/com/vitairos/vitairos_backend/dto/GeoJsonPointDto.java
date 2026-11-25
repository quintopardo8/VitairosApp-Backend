package com.vitairos.vitairos_backend.dto;

import java.util.List;

public class GeoJsonPointDto {
    private String type = "Point";
    private List<Double> coordinates; // [longitud, latitud]

    public GeoJsonPointDto() {}

    public GeoJsonPointDto(String type, List<Double> coordinates) {
        this.type = type;
        this.coordinates = coordinates;
    }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public List<Double> getCoordinates() { return coordinates; }
    public void setCoordinates(List<Double> coordinates) { this.coordinates = coordinates; }
}
package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import java.util.Map;
@Data
@NoArgsConstructor
public class FeatureDTO {
    private String type;
    private Geometry geometry;

    private Map<String, String> properties;

    private Polygon box;
}

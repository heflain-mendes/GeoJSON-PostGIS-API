package com.example.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.geom.Polygon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Map;

@Data
@NoArgsConstructor
public class Feature2 {
    private String type;
    private Double[] geometry;

    private Map<String, String> properties;

    private Double[] box;

    @Override
    public String toString() {
        return "Feature2{" +
                "type='" + type + '\'' +
                ", geometry=" + Arrays.toString(geometry) +
                ", properties=" + properties +
                ", box=" + Arrays.toString(box) +
                '}';
    }
}
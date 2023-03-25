package com.example.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;
import org.locationtech.jts.geom.*;

import java.util.Map;

@Entity
@Data
@NoArgsConstructor
@SQLDelete(sql = "DELETE FROM feature WHERE geometry = ?")
public class Feature {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column
    private String type;

    @Column(columnDefinition = "geometry(GEOMETRY,4326)")
    private Geometry geometry;

    @ElementCollection
    @CollectionTable(name = "properties",
            joinColumns = {@JoinColumn(name = "properties_id", referencedColumnName = "id")})
    @MapKeyColumn(name = "properties")
    @Column(name = "value")
    private Map<String, String> properties;

    @Column(columnDefinition = "geometry(POLYGON,4326)")
    private Polygon box;
}
package com.example.controller;

import com.bedatadriven.jackson.datatype.jts.GeoJson;
import com.example.model.Feature2;
import com.example.model.FeatureDTO;
import com.example.service.FeatureService;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.locationtech.jts.io.geojson.GeoJsonWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/city")
public class FeatureController {
    @Autowired
    private FeatureService service;
    private GeoJsonWriter geoJsonWriter;
    private GeoJsonReader geoJsonReader;
    @PostMapping
    public void save(@RequestBody Feature2 feature2){
        System.out.println(feature2.toString());

    }

    @GetMapping
    public List<FeatureDTO> findAll(){
        return service.findAll();
    }

    @DeleteMapping
    public void delete(@RequestBody FeatureDTO featureDTO){
        service.delete(featureDTO);
    }
}

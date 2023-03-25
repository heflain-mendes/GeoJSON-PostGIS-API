package com.example.util;

import com.example.model.Feature;
import com.example.model.FeatureDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Component
public class FeatureMapper {
    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private ObjectMapper objectMapper;

    public List<FeatureDTO> convertToDTO (List<Feature> features){
        List<FeatureDTO> featureDTOS = new ArrayList<>();

        for(var f : features){
            featureDTOS.add(modelMapper.map(f, FeatureDTO.class));
        }

        return featureDTOS;
    }

    public FeatureDTO convertToDTO(Feature feature){
        return modelMapper.map(feature, FeatureDTO.class);
    }

    public Feature convertToFeature(FeatureDTO featureDTO){
        return modelMapper.map(featureDTO, Feature.class);
    }

    public List<Feature> convertToFeature(List<FeatureDTO> featureDTOS) {
        List<Feature> features = new ArrayList<>();

        for (var f : featureDTOS) {
            features.add(modelMapper.map(f, Feature.class));
        }

        return features;
    }

    public FeatureDTO convertToDTO(String geoJson) throws JsonProcessingException {
        var obj = objectMapper.readValue(geoJson, new TypeReference<Map<String, Object>>(){});
        FeatureDTO featureDTO = new FeatureDTO();

        featureDTO.setType((String) obj.get("type"));
        featureDTO.setProperties((Map<String, String>) obj.get("properties"));
        featureDTO.setGeometry(objectMapper);

    }
}

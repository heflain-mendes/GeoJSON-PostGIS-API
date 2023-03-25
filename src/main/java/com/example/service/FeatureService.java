package com.example.service;

import com.example.model.FeatureDTO;
import com.example.repository.FeatureRepository;
import com.example.util.FeatureMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepository repository;

    @Autowired
    private FeatureMapper featureMapper;

    public FeatureDTO save(FeatureDTO feature){
        return featureMapper.convertToDTO(repository.save(featureMapper.convertToFeature(feature)));
    }

    public List<FeatureDTO> findAll(){
        return featureMapper.convertToDTO(repository.findAll());
    }

    public void delete(FeatureDTO featureDTO){
        repository.delete(
                featureMapper.convertToFeature(featureDTO)
        );
    }
}

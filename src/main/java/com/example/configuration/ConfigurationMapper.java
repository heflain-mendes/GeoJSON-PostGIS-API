package com.example.configuration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.locationtech.jts.geom.Geometry;
import org.locationtech.jts.io.ParseException;
import org.locationtech.jts.io.geojson.GeoJsonReader;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.support.DefaultFormattingConversionService;
import org.springframework.format.support.FormattingConversionService;

@Configuration
public class ConfigurationMapper {
    @Bean
    public ModelMapper modelMapper(){
        return new ModelMapper();
    }

    @Bean
    public ObjectMapper objectMapper(){
        return new ObjectMapper();
    }

    @Bean
    public FormattingConversionService conversionService() {
        FormattingConversionService conversionService = new DefaultFormattingConversionService();
        conversionService.addConverter(new StringToIntegerConverter());
        return conversionService;
    }

    private static class StringToIntegerConverter implements Converter<Object, Geometry> {
        private GeoJsonReader geoJsonReader;
        private ObjectMapper objectMapper;

        public StringToIntegerConverter(){
            geoJsonReader = new GeoJsonReader();
            objectMapper = new ObjectMapper();
        }

        @Override
        public Geometry convert(Object source) {
            System.out.println(source.toString());
            try {
                return geoJsonReader.read(objectMapper.writeValueAsString(source));
            } catch (ParseException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            } catch (JsonProcessingException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }
        }
    }
}

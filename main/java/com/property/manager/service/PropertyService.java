package com.property.manager.service;


import com.propertymanager.entities.Property;
import com.property.manager.repository.PropertyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PropertyService {

    @Autowired
    private PropertyRepository propertyRepository;

    public Property createProperty(Property property) {
        return propertyRepository.save(property);
    }

    public List<Property> findByLocation(String location) {
        return propertyRepository.findByLocation(location);
    }
}


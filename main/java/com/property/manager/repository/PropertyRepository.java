package com.property.manager.repository;

import com.propertymanager.entities.Property;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PropertyRepository extends JpaRepository<Property, Long> {
    List<Property> findByLocation(String location);
}

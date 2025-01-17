package com.property.manager.controller;

import com.propertymanager.entities.Property;
import com.property.manager.repository.PropertyRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // Δηλώνει ότι η κλάση είναι REST API controller
@RequestMapping("/api/properties") // Καθορίζει την βάση URL για όλα τα endpoints αυτού του controller
public class PropertyController {

    private final PropertyRepository propertyRepository;

    // Εισαγωγή του PropertyRepository μέσω Constructor Injection
    public PropertyController(PropertyRepository propertyRepository) {
        this.propertyRepository = propertyRepository;
    }

    // Η μέθοδος POST για να δημιουργήσουμε ένα νέο ακίνητο
    @PostMapping // Δηλώνει ότι αυτή η μέθοδος χειρίζεται τις POST αιτήσεις
    public ResponseEntity<Property> createProperty(@RequestBody Property property) {
        try {
            // Αποθήκευση του Property στην βάση δεδομένων
            Property savedProperty = propertyRepository.save(property);
            return ResponseEntity.status(HttpStatus.CREATED).body(savedProperty); // Επιστρέφει το νέο ακίνητο με status 201 (Created)
        } catch (Exception e) {
            // Αν κάτι πάει στραβά, επιστρέφουμε 500 Internal Server Error
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
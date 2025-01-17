package com.propertymanager.entities;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Property {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String address;

    private Double pricePerNight;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Booking> bookings;

    @OneToMany(mappedBy = "property", cascade = CascadeType.ALL)
    private List<Review> reviews;

    // Getters and Setters
}

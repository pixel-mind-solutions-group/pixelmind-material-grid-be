package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehicle")
    private Integer idvehicle;

    @Column(name = "vehicle_number", nullable = false)
    private String vehicleNumber;

    @ManyToOne
    @JoinColumn(name = "vehicle_type_idvehicle_type", nullable = false)
    private VehicleType vehicleType;

    @Column(name = "capacity", nullable = false)
    private Integer capacity;
}
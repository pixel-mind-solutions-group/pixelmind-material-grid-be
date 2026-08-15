package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "vehicle_type")
public class VehicleType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idvehicle_type")
    private Integer idvehicleType;

    @Column(name = "type", nullable = false)
    private String type;

    @ManyToOne
    @JoinColumn(name = "unit_type_idunit_type", nullable = false)
    private UnitType unitType;
}

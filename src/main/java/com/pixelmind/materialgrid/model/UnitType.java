package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "unit_type")
public class UnitType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idunit_type")
    private Integer idunitType;

    @Column(name = "type", nullable = false)
    private String type;
}

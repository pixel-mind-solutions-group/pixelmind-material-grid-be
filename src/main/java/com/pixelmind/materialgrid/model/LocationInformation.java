package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "location_information")
public class LocationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idlocation_information")
    private Integer idlocationInformation;

    @ManyToOne
    @JoinColumn(name = "person_idperson", nullable = false)
    private Person person;

    @Column(name = "address")
    private String address;

    @Column(name = "is_primary")
    private Boolean isPrimary;
}

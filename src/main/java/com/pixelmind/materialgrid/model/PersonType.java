package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person_type")
public class PersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson_type")
    private Integer idpersonType;

    @Column(name = "name")
    private String name;

    @Column(name = "type")
    private String type;
}

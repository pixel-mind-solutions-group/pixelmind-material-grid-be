package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "person_has_person_type")
public class PersonHasPersonType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idperson_has_person_type")
    private Integer idpersonHasPersonType;

    @ManyToOne
    @JoinColumn(name = "person_idperson", nullable = false)
    private Person person;

    @ManyToOne
    @JoinColumn(name = "person_type_idperson_type", nullable = false)
    private PersonType personType;
}

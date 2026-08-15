package com.pixelmind.materialgrid.model;


import jakarta.persistence.*;

@Entity
@Table(name = "communication_information")
public class CommunicationInformation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcommunication_information")
    private Integer idcommunicationInformation;

    @ManyToOne
    @JoinColumn(name = "person_idperson", nullable = false)
    private Person person;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    @Column(name = "is_primary")
    private Boolean isPrimary;
}

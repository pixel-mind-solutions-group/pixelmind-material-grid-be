package com.pixelmind.materialgrid.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "route")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idroute")
    private Integer idroute;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "location_from", nullable = false)
    private String locationFrom;

    @Column(name = "location_to", nullable = false)
    private String locationTo;

    @Column(name = "distance", nullable = false)
    private BigDecimal distance;
}

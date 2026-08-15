package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "transport_trip")
public class TransportTrip {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransport_trip")
    private Integer idtransportTrip;

    @Column(name = "ref_no", nullable = false)
    private String refNo;

    @Column(name = "prepaid_transport_price", nullable = false)
    private BigDecimal prepaidTransportPrice;

    @Column(name = "total_transport_price", nullable = false)
    private BigDecimal totalTransportPrice;

    @Column(name = "total_buying_price", nullable = false)
    private BigDecimal totalBuyingPrice;

    @Column(name = "total_selling_price", nullable = false)
    private BigDecimal totalSellingPrice;

    @ManyToOne
    @JoinColumn(name = "route_idroute", nullable = false)
    private Route route;

    @ManyToOne
    @JoinColumn(name = "vehicle_idvehicle", nullable = false)
    private Vehicle vehicle;

    @ManyToOne
    @JoinColumn(name = "person_idperson_customer", nullable = false)
    private Person customer;

    @ManyToOne
    @JoinColumn(name = "person_idperson_driver", nullable = false)
    private Person driver;

    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "created_by", nullable = false)
    private String createdBy;

    @Column(name = "updated_at", nullable = false)
    private LocalDateTime updatedAt;

    @Column(name = "updated_by", nullable = false)
    private String updatedBy;
}
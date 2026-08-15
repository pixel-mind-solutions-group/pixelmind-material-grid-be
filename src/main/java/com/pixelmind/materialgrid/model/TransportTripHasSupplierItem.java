package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transport_trip_has_supplier_item")
public class TransportTripHasSupplierItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtransport_trip_has_supplier_item")
    private Integer idtransportTripHasSupplierItem;

    @Column(name = "unit", nullable = false)
    private BigDecimal unit;

    @Column(name = "item_base_selling_price", nullable = false)
    private BigDecimal itemBaseSellingPrice;

    @Column(name = "total_selling_price", nullable = false)
    private BigDecimal totalSellingPrice;

    @Column(name = "item_base_buying_price", nullable = false)
    private BigDecimal itemBaseBuyingPrice;

    @Column(name = "item_buying_price", nullable = false)
    private BigDecimal itemBuyingPrice;

    @Column(name = "total_buying_price", nullable = false)
    private BigDecimal totalBuyingPrice;

    @Column(name = "transport_price_per_unit", nullable = false)
    private BigDecimal transportPricePerUnit;

    @Column(name = "transport_price", nullable = false)
    private BigDecimal transportPrice;

    @Column(name = "is_for_transport_trip", nullable = false)
    private Boolean isForTransportTrip;

    @ManyToOne
    @JoinColumn(name = "transport_trip_idtransport_trip", nullable = false)
    private TransportTrip transportTrip;

    @ManyToOne
    @JoinColumn(name = "item_has_supplier_iditem_has_supplier", nullable = false)
    private ItemHasSupplier itemHasSupplier;
}
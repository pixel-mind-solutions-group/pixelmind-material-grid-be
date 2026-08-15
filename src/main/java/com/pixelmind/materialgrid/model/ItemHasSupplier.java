package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item_has_supplier")
public class ItemHasSupplier {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem_has_supplier")
    private Integer iditemHasSupplier;

    @ManyToOne
    @JoinColumn(name = "item_iditem", nullable = false)
    private Item item;

    @ManyToOne
    @JoinColumn(name = "person_idperson_supplier", nullable = false)
    private Person supplier;

    @Column(name = "unit", nullable = false)
    private BigDecimal unit;

    @Column(name = "base_buying_price", nullable = false)
    private BigDecimal baseBuyingPrice;

    @Column(name = "base_selling_price", nullable = false)
    private BigDecimal baseSellingPrice;
}
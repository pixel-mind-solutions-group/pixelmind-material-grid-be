package com.pixelmind.materialgrid.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "item")
public class Item {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iditem")
    private Integer iditem;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "code", nullable = false)
    private String code;

    @ManyToOne
    @JoinColumn(name = "unit_type_idunit_type", nullable = false)
    private UnitType unitType;

    @Column(name = "transport_price_per_km", nullable = false)
    private BigDecimal transportPricePerKm;

    @ManyToOne
    @JoinColumn(name = "category_idcategory", nullable = false)
    private Category category;
}

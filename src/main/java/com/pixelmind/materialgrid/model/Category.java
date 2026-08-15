package com.pixelmind.materialgrid.model;

import jakarta.persistence.*;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategory")
    private Integer idcategory;

    @Column(name = "category", nullable = false)
    private String category;
}
package com.pixelmind.materialgrid.model.user;


import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role")
public class UserRole {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser_role")
    private Integer iduserRole;

    @Column(name = "role_name", nullable = false)
    private String roleName;

    @Column(name = "active")
    private Boolean active;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;
}

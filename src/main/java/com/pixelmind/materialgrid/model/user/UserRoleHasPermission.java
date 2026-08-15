package com.pixelmind.materialgrid.model.user;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "user_role_has_permission")
public class UserRoleHasPermission {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "iduser_role_has_permission")
    private Integer iduserRoleHasPermission;

    @ManyToOne
    @JoinColumn(name = "user_role_iduser_role", nullable = false)
    private UserRole userRole;

    @ManyToOne
    @JoinColumn(name = "permission_idpermission", nullable = false)
    private Permission permission;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "updated_by")
    private String updatedBy;
}

package com.pixelmind.materialgrid.repository;

import com.pixelmind.materialgrid.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

    Optional<Vehicle> findByVehicleNumberIgnoreCase(String vehicleNumber);

    boolean existsByVehicleNumberIgnoreCase(String vehicleNumber);

    @Query("SELECT v FROM Vehicle v WHERE LOWER(v.vehicleNumber) LIKE LOWER(CONCAT('%', :query, '%'))")
    List<Vehicle> searchByVehicleNumber(@Param("query") String query);

    List<Vehicle> findByStatus(String status);
}

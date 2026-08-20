package com.pixelmind.materialgrid.service.vehicle;

import com.pixelmind.materialgrid.dto.vehicle.VehicleRequestDTO;
import com.pixelmind.materialgrid.dto.vehicle.VehicleResponseDTO;

import java.util.List;

public interface VehicleService {
    List<VehicleResponseDTO> getAllVehicles();
    List<VehicleResponseDTO> searchVehicles(String query);
    VehicleResponseDTO createVehicle(VehicleRequestDTO request);
    VehicleResponseDTO updateVehicle(Integer id, VehicleRequestDTO request);
    VehicleResponseDTO updateStatus(Integer id, String status);
}

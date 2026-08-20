package com.pixelmind.materialgrid.service.vehicle.impl;

import com.pixelmind.materialgrid.dto.vehicle.VehicleRequestDTO;
import com.pixelmind.materialgrid.dto.vehicle.VehicleResponseDTO;
import com.pixelmind.materialgrid.model.Vehicle;
import com.pixelmind.materialgrid.repository.VehicleRepository;
import com.pixelmind.materialgrid.service.vehicle.VehicleService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@Service
public class VehicleServiceImpl implements VehicleService {

    private final VehicleRepository vehicleRepository;

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponseDTO> getAllVehicles() {
        return vehicleRepository.findAll()
                .stream()
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<VehicleResponseDTO> searchVehicles(String query) {
        List<Vehicle> results = (query == null || query.isBlank())
                ? vehicleRepository.findByStatus("ACTIVE")
                : vehicleRepository.searchByVehicleNumber(query.trim());

        return results.stream()
                .filter(v -> "ACTIVE".equals(v.getStatus()))
                .map(this::toResponse)
                .collect(Collectors.toList());
    }

    @Override
    @Transactional
    public VehicleResponseDTO createVehicle(VehicleRequestDTO request) {
        String regNum = request.getVehicleNumber().trim().toUpperCase();

        if (vehicleRepository.existsByVehicleNumberIgnoreCase(regNum)) {
            throw new IllegalArgumentException("Vehicle '" + regNum + "' already exists.");
        }

        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleNumber(regNum);
        vehicle.setCapacityInCube(request.getCapacityInCube());
        vehicle.setStatus(request.getStatus() != null ? request.getStatus().toUpperCase() : "ACTIVE");
        vehicle.setCreatedAt(LocalDateTime.now());
        vehicle.setUpdatedAt(LocalDateTime.now());

        Vehicle saved = vehicleRepository.save(vehicle);
        log.info("Vehicle created: {}", saved.getVehicleNumber());
        return toResponse(saved);
    }

    @Override
    @Transactional
    public VehicleResponseDTO updateVehicle(Integer id, VehicleRequestDTO request) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + id));

        vehicle.setCapacityInCube(request.getCapacityInCube());
        if (request.getStatus() != null) {
            vehicle.setStatus(request.getStatus().toUpperCase());
        }
        vehicle.setUpdatedAt(LocalDateTime.now());

        Vehicle saved = vehicleRepository.save(vehicle);
        log.info("Vehicle updated: {}", saved.getVehicleNumber());
        return toResponse(saved);
    }

    @Override
    @Transactional
    public VehicleResponseDTO updateStatus(Integer id, String status) {
        Vehicle vehicle = vehicleRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Vehicle not found: " + id));

        String newStatus = status.trim().toUpperCase();
        if (!newStatus.equals("ACTIVE") && !newStatus.equals("INACTIVE")) {
            throw new IllegalArgumentException("Invalid status: " + status + ". Use ACTIVE or INACTIVE.");
        }

        vehicle.setStatus(newStatus);
        vehicle.setUpdatedAt(LocalDateTime.now());

        Vehicle saved = vehicleRepository.save(vehicle);
        log.info("Vehicle {} status -> {}", saved.getVehicleNumber(), saved.getStatus());
        return toResponse(saved);
    }

    // ─── Mapper ────────────────────────────────────────────────────────────────
    private VehicleResponseDTO toResponse(Vehicle v) {
        return new VehicleResponseDTO(
                v.getIdvehicle(),
                v.getVehicleNumber(),
                v.getCapacityInCube(),
                v.getStatus()
        );
    }
}

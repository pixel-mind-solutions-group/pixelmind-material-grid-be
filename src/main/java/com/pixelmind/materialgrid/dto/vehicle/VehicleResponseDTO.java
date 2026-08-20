package com.pixelmind.materialgrid.dto.vehicle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class VehicleResponseDTO {
    private Integer id;
    private String vehicleNumber;
    private Double capacityInCube;
    private String status;
}

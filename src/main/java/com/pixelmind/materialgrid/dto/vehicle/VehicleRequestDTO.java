package com.pixelmind.materialgrid.dto.vehicle;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class VehicleRequestDTO {
    private String vehicleNumber;
    private Double capacityInCube;
    private String status;
}

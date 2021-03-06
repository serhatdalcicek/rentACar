package com.etiya.rentACar.business.requests.maintenanceRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequest {


    private int id;

    private String description;

    private LocalDate dateAdded;

    private LocalDate dateReturned;

    private int carId;

}

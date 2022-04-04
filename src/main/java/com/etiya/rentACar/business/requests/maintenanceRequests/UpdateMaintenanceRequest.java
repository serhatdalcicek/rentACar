package com.etiya.rentACar.business.requests.maintenanceRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

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

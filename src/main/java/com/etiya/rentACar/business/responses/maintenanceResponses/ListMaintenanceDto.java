package com.etiya.rentACar.business.responses.maintenanceResponses;

import java.time.LocalDate;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListMaintenanceDto {

	private int id;

	private String description;

	private LocalDate dateAdded;

	private LocalDate dateReturned;

	private int carDescription;

}

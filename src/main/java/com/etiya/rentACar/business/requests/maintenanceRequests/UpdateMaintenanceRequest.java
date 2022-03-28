package com.etiya.rentACar.business.requests.maintenanceRequests;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateMaintenanceRequest {

	
	private int maintenanceId;
	
	private LocalDate dateReturned;
	
	private String description;
}

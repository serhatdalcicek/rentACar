package com.etiya.rentACar.business.requests.maintenanceRequests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceRequest {

	@JsonIgnore
	private int maintenanceId;

	private LocalDate dateAdded;

	private LocalDate dateReturned;

	private int carId;
	
	private int statusId;

	
}

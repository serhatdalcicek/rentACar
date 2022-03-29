package com.etiya.rentACar.business.requests.carMaintenanceRequests;

import java.time.LocalDate;

/*import com.etiya.rentACar.entities.Situations;*/
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarMaintenanceRequest {

	@JsonIgnore
	private int maintenanceId;

	private LocalDate dateAdded;

	private LocalDate dateReturned;
	
	private String description;
	
	private String carDescription;

	private int carId;
	

	
	

	
}

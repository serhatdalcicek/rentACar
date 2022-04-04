package com.etiya.rentACar.business.requests.maintenanceRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/*import com.etiya.rentACar.entities.Situations;*/
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateMaintenanceRequest {

	@JsonIgnore
	private int id;

	private String description;

	private LocalDate dateAdded;

	private LocalDate dateReturned;

	private int carId;

}
package com.etiya.rentACar.business.responses.carResponses;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDto {

	private int carId;

	private double dailyPrice;

	private String description;

	private int modelYear;

	private String colorName;

	private String brandName;
	
	private String statusName;
	
	@JsonIgnore
	private int statusId;
}

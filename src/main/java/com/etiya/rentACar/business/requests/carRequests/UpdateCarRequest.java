package com.etiya.rentACar.business.requests.carRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

	
	private int carId;
	
	private double dailyPrice;
	
	private String description;
	
	private int modelYear;
	
	private int colorId;
	
	private int brandId;
	
	@JsonIgnore
	private int statusId;
}

package com.etiya.rentACar.business.requests.carRequests;


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
	
    //private CarStates statesName;

}

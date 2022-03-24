package com.etiya.rentACar.business.responses.carResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCarDto {
	
private int id;

private double dailyPrice;

private String description;

private int modelYear;

private String brandName;

private String colorName;

}

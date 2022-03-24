package com.etiya.rentACar.business.requests.damageRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //
@NoArgsConstructor // parametresiz const
public class CreateDamageRequest {
   
	@JsonIgnore
	private int id;
    
	private int carId;

	private int date;

	private String description;

}
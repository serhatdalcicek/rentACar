package com.etiya.rentACar.business.requests.carDamageRequests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor // parametresiz constructor
public class CreateCarDamageRequest {

	@JsonIgnore
	private int damageId;

	private int carId;

	private LocalDate accidentDate;

	private String description;

}
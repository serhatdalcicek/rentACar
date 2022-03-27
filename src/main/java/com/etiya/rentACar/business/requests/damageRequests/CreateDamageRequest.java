package com.etiya.rentACar.business.requests.damageRequests;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //
@NoArgsConstructor // parametresiz const
public class CreateDamageRequest {

	@JsonIgnore
	private int damageId;

	private int carId;

	private LocalDate date;

	private String description;

}
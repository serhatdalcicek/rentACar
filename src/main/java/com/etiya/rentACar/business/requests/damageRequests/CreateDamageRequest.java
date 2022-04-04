package com.etiya.rentACar.business.requests.damageRequests;

import java.time.LocalDate;

import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor // parametresiz constructor
public class CreateDamageRequest {

	@JsonIgnore
	private int id;

	private String description;

	private LocalDate date;

	private  int carId;

}
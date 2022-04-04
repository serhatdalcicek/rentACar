package com.etiya.rentACar.business.requests.damageRequests;

import java.time.LocalDate;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data // get ve set
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor // parametresiz constructor
public class UpdateDamageRequest {


	@JsonIgnore
	private int id;

	private String description;

	private LocalDate date;

	private  int carId;

}

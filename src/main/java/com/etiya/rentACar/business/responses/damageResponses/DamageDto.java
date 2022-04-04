package com.etiya.rentACar.business.responses.damageResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class DamageDto {

	private int id;

	private String description;

	private LocalDate date;

	private String carDescription;
}

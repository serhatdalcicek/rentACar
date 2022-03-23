package com.etiya.rentACar.business.requests.damageRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //
@NoArgsConstructor // parametresiz const
public class CreateDamageRequest {

	private int carId;

	private String date;

	private String description;

}
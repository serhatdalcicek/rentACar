package com.etiya.rentACar.business.requests.stateRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStatusRequest {
	
	@JsonIgnore
	private int statusId;

	private String statusName;
}

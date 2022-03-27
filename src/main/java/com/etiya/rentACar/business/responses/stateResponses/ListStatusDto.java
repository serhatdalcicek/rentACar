package com.etiya.rentACar.business.responses.stateResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListStatusDto {

	private int statusId;
	
	private String statusName;

}

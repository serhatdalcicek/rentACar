package com.etiya.rentACar.business.responses.statusResponses;



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

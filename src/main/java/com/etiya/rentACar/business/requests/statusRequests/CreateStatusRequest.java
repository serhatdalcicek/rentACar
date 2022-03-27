package com.etiya.rentACar.business.requests.statusRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateStatusRequest {
    
	@JsonIgnore
	private int id;
	
	private String name;
}

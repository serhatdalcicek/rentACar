package com.etiya.rentACar.business.requests.brandRequests;

import com.etiya.rentACar.entities.Brand;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data //get ve set
@AllArgsConstructor //
@NoArgsConstructor //parametresiz const
public class CreateBrandRequest {
	
	private String name;
    
	
}

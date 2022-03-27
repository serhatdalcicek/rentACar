package com.etiya.rentACar.business.requests.colorRequests;



import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data //get ve set
@AllArgsConstructor //
@NoArgsConstructor //parametresiz const
public class CreateColorRequest {
	
	  @JsonIgnore
	  private int colorId;
	
	  private String colorName;
}


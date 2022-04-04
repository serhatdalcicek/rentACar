package com.etiya.rentACar.business.requests.damageRequests;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // get ve set
@AllArgsConstructor //parametreli constructor
@NoArgsConstructor // parametresiz constructor
public class DeleteDamageRequest {
    
	
	private int damageId;

	
}

package com.etiya.rentACar.business.responses.damageResponses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListDamageDto {
	
   
	private int damageId;
	
    private int carId;
    
    private String carDescription;
    
    private LocalDate date;
    
    private String description;
   
  
   }
   


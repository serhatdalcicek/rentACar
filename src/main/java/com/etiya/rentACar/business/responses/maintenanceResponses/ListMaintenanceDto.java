package com.etiya.rentACar.business.responses.maintenanceResponses;

import java.time.LocalDate;

import com.etiya.rentACar.entities.Situations;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ListMaintenanceDto {

	private int maintananceId;

	private String carDescription;

	private LocalDate dateAdded;

	private LocalDate dateReturned;
	
    private String statusName;
    
    private int statusId;
    
    private Situations situations;


}

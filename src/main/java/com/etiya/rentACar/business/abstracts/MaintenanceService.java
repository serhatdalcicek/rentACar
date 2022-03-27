package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.entities.Situations;

public interface MaintenanceService {
	
	void add(CreateMaintenanceRequest createMaintenanceRequest,Situations situations);

	List<ListMaintenanceDto> getAll();
	
	List<ListMaintenanceDto> getAllSituations(Situations situations);

	List<ListMaintenanceDto> getByCarId(int id);




	/*List<ListMaintenanceDto> getByStatusId(int id);*/

}
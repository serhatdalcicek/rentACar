package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;

public interface MaintenanceService {
	
	void add(CreateMaintenanceRequest createMaintenanceRequest); //
	void update(UpdateMaintenanceRequest updateMaintenanceRequest);

	List<ListMaintenanceDto> getAll();
	
   
	List<ListMaintenanceDto> getByCarId(int id);

	List<ListMaintenanceDto> getById(int id);

	/*List<ListMaintenanceDto> getByStatusId(int id);*/

}
package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.UpdateCarMaintenanceRequest;
import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;

public interface CarMaintenanceService {
	
	
	List<ListCarMaintenanceDto> getAll();
	List<ListCarMaintenanceDto> getByCarId(int id);
	


	
	void add(CreateCarMaintenanceRequest createCarMaintenanceRequest); //
	void update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest);
	void delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest);



}
package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenancesController {
	
	private MaintenanceService maintenanceService;

	public MaintenancesController(MaintenanceService maintenanceService) {
		
		this.maintenanceService = maintenanceService;
	}

	@PostMapping(name = "/add")
	public void add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) { 
		
		maintenanceService.add(createMaintenanceRequest); //
	}
	
	 @PostMapping("/update")
	    public void update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest){
	        this.maintenanceService.update(updateMaintenanceRequest);
	    }

	/*
	 * @GetMapping("/getByCarId") public void getByCarId(@RequestParam int id) {
	 * maintenanceService.getByCarId(id);
	 * 
	 * }
	 */
	@GetMapping("/getbycarid/{id}")
	public List<ListMaintenanceDto> getByCarId(int id) {
		
		return this.maintenanceService.getByCarId(id);
	}

	@GetMapping("/getall")
	public List<ListMaintenanceDto> getAll() {
		
		return maintenanceService.getAll();
	}
	

}

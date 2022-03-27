package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.entities.Situations;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/maintenances")
public class MaintenancesController {
	
	private MaintenanceService maintenanceService;

	public MaintenancesController(MaintenanceService maintenanceService) {
		
		this.maintenanceService = maintenanceService;
	}

	@PostMapping(name = "/add")
	public void add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest,@RequestParam Situations situations) { //
		
		maintenanceService.add(createMaintenanceRequest, situations); //
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
	@GetMapping("/getallsituations")
	public List<ListMaintenanceDto> getAll(@RequestParam Situations situations){
		return maintenanceService.getAllSituations(situations);
	}

}

package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.CarMaintenanceService;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.UpdateCarMaintenanceRequest;
import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/api/maintenances")
public class CarMaintenancesController {

	private CarMaintenanceService carMaintenanceService;

	public CarMaintenancesController(CarMaintenanceService carMaintenanceService) {

		this.carMaintenanceService = carMaintenanceService;
	}

	@PostMapping(name = "/add")
	public void add(@RequestBody CreateCarMaintenanceRequest createCarMaintenanceRequest) {

		carMaintenanceService.add(createCarMaintenanceRequest); //
	}

	@PostMapping("/update")
	public void update(@RequestBody UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		this.carMaintenanceService.update(updateCarMaintenanceRequest);
	}

	@GetMapping("/getall")
	public List<ListCarMaintenanceDto> getAll() {

		return carMaintenanceService.getAll();
	}

	@GetMapping("/getbycarid/{id}")
	public List<ListCarMaintenanceDto> getByCarId(int id) {

		return this.carMaintenanceService.getByCarId(id);
	}

}

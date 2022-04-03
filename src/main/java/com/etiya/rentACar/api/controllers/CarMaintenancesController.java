package com.etiya.rentACar.api.controllers;

import java.util.List;

import com.etiya.rentACar.business.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

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

	@PostMapping("/add")
	public Result add(@RequestBody CreateCarMaintenanceRequest createCarMaintenanceRequest) {

		return this.carMaintenanceService.add(createCarMaintenanceRequest); //
	}

	@PutMapping("/update")
	public Result update(@RequestBody UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {

		return this.carMaintenanceService.update(updateCarMaintenanceRequest);
	}
	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {

		return this.carMaintenanceService.delete(deleteCarMaintenanceRequest);
	}

	@GetMapping("/getall")
	public DataResult<List<ListCarMaintenanceDto>> getAll() {

		return this.carMaintenanceService.getAll();
	}

	@GetMapping("/getbycarid/{id}")
	public DataResult<List<ListCarMaintenanceDto>> getByCarId(int id) {

		return this.carMaintenanceService.getByCarId(id);
	}

}

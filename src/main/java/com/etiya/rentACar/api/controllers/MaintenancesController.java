package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.DeleteMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/maintanances")
public class MaintenancesController {


	private MaintenanceService maintenanceService;

	@Autowired
	public void MaintenancesControllerController(MaintenanceService maintenanceService) {
		this.maintenanceService = maintenanceService;
	}


	@PostMapping("/add")
	public Result add(@RequestBody CreateMaintenanceRequest createMaintenanceRequest) {
		return this.maintenanceService.add(createMaintenanceRequest);
	}

	@PutMapping("/update")
	public Result update(@RequestBody UpdateMaintenanceRequest updateMaintenanceRequest) {
		return this.maintenanceService.update(updateMaintenanceRequest);
	}

	@DeleteMapping("/delete")
	public Result delete(@RequestBody DeleteMaintenanceRequest deleteMaintenanceRequest) {
		return this.maintenanceService.delete(deleteMaintenanceRequest);
	}

	@GetMapping("/getAll")
	public DataResult<List<ListMaintenanceDto>> getAll() {
		return this.maintenanceService.getAll();
	}

	@GetMapping("/getByCarId")
	public DataResult<List<ListMaintenanceDto>> getByCarId(@RequestParam("car") int id) {
		return this.maintenanceService.getAllMaintenanceByCarId(id);
	}


}

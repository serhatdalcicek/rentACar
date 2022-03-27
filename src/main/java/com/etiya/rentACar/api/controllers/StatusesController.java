package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.StatusService;
import com.etiya.rentACar.business.requests.stateRequests.CreateStatusRequest;
import com.etiya.rentACar.business.responses.stateResponses.ListStatusDto;

@RestController // Bir Rest controller olabilmesi için bu tanım gereklidir.
@RequestMapping("/api/statuses") // Mapping işlemi standart olarak /api ile başlar.
public class StatusesController {

	StatusService statusService;

	public StatusesController(StatusService statusService) {
		super();
		this.statusService = statusService;
	}

	@PostMapping("/add") // Bir post operasyonu api/add dediğinde veriler eklenir.
	public void add(CreateStatusRequest createStatusRequest) {

		statusService.add(createStatusRequest);
	}

	@GetMapping("/getall") // Bir get operasyonu api/status dediğinde veriler gelir.
	public List<ListStatusDto> getAll() {

		return statusService.getAll();
	}

	@GetMapping("/getbystatusid")
	public List<ListStatusDto> getByStatusId(int id) {

		return this.statusService.getByStatusId(id);

		/*
		 * public List<ListStatusDto> getByStatusId(@RequestParam("statusId") int id){
		 * return this.statusService.getByStatusId(id);
		 */
	}

}

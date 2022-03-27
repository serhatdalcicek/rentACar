package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.StatusService;
import com.etiya.rentACar.business.requests.statusRequests.CreateStatusRequest;
import com.etiya.rentACar.business.responses.statusResponses.ListStatusDto;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController //Bir Rest controller olabilmesi için bu tanım gereklidir.
@RequestMapping("/api/statuses") //Mapping işlemi standart olarak /api ile başlar.
public class StatusesController {
    
	private StatusService statusService;
	
	public StatusesController(StatusService statusService) {
		
		this.statusService = statusService;
	}
	@PostMapping("/add")
	public void add(@RequestBody CreateStatusRequest createStatusRequest) {
		
		this.statusService.add(createStatusRequest);
	}
	@GetMapping("/getall")
	
	public List<ListStatusDto> getAll(){
		
		return statusService.getAll();
	}
	
}

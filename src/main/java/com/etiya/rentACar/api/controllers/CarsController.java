package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	private CarService carService;

	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateCarRequest createCarRequest) {
		this.carService.add(createCarRequest);
	}
	@GetMapping("/getall")
	public List<ListCarDto>getAll(){
		return this.carService.getAll();
	}
	@GetMapping("/getallbymodelyear")
	public List<ListCarDto>getAllByModelYear(@RequestParam("modelYear") short modelYear){
		return this.carService.getAllByModelYear(modelYear);
	}
	@GetMapping("/getallpage")
	List<ListCarDto> getAllPage(int pageNo,int pageSize) {
		return this.carService.getAllPage(pageNo, pageSize);
	}
		//hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
	
	@GetMapping("/getallsorted")
	List<ListCarDto> getAllSorted() {
		return this.carService.getAllSorted();
	} //sorted sıralı demektir.
	
		
	}
	

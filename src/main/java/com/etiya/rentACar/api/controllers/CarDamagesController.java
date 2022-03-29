package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.etiya.rentACar.business.abstracts.CarDamageService;
import com.etiya.rentACar.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.etiya.rentACar.business.responses.carDamageResponses.ListCarDamageDto;

@RestController
@RequestMapping("/api/damages")
public class CarDamagesController {
	private CarDamageService carDamageService;

	public CarDamagesController(CarDamageService carDamageService) {
		this.carDamageService = carDamageService;
	}

	@PostMapping("/add")
	public void add(@RequestBody CreateCarDamageRequest createCarDamageRequest) {
		this.carDamageService.add(createCarDamageRequest);
	}
	@GetMapping("/getall")
	public List<ListCarDamageDto> getAll(){
		return this.carDamageService.getAll();
	}
	@GetMapping("/getbycarid")
	public List<ListCarDamageDto> getByCarId(@RequestParam("carId") int id){
		return this.carDamageService.getAllByCarId(id);
	}
	@GetMapping("/getallpaged")
	List<ListCarDamageDto> getAllPaged(int pageNo,int pageSize) {
		return this.carDamageService.getAllPaged(pageNo, pageSize);
	}
	@GetMapping("/getallsorted")
	 public  List<ListCarDamageDto> getAllSorted(String option,String fields){
		return this.carDamageService.getAllSorted(option,fields);
	}
}

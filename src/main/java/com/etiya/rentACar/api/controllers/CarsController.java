package com.etiya.rentACar.api.controllers;

import java.util.List;

import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/cars")
public class CarsController {
	private CarService carService;

	public CarsController(CarService carService) {
		this.carService = carService;
	}

	@PostMapping("/add") //valid dediğimizde crreate de yazdığımız anatosyonların devreye girmesini sağlar
	public Result add(@RequestBody @Valid CreateCarRequest createCarRequest) {

		return this.carService.add(createCarRequest);
	}
	@PutMapping("/update")
    public Result update(@RequestBody   UpdateCarRequest updateCarRequest) {

		return  this.carService.update(updateCarRequest);
    }
	@DeleteMapping("/delete")
    public Result delete(@RequestBody  DeleteCarRequest deleteCarRequest) {

		return this.carService.delete(deleteCarRequest);
	}
	@GetMapping("/getall")
	public DataResult<List<ListCarDto>>getAll(){

		return this.carService.getAll();
	}
	@GetMapping("/getbycityid")
	public DataResult<List<ListCarDto>> getByCityId(@RequestParam("cityId") int id) {

		return carService.getByCityId(id);
	}

	@GetMapping("/getallbymodelyear")
	public DataResult<List<ListCarDto>>getAllByModelYear(@RequestParam("modelYear") int modelYear){

		return this.carService.getAllByModelYear(modelYear);
	}
	@GetMapping("/getallpaged")		//hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
	public DataResult<List<ListCarDto>> getAllPaged(int pageNo,int pageSize) {
		
		return this.carService.getAllPaged(pageNo, pageSize);
	}
	
	@GetMapping("/getallsorted")//sorted sıralı demek
	 public  DataResult<List<ListCarDto>> getAllSorted(String option,String fields){
		
		return this.carService.getAllSorted(option,fields);
	}
	
		
	}
	


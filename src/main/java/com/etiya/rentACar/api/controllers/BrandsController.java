package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
//import org.springframework.beans.factory.annotation.Autowired;
import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

import javax.validation.Valid;

//dış dünya ile iletişim kurar 
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	@Autowired
	public BrandsController(BrandService brandService) {

		this.brandService = brandService;
	}

	// veri tabanı nesnesini controllera taşımak yasak
	@PostMapping("/add")
	public Result add(@RequestBody @Valid CreateBrandRequest createBrandRequest) {

		return this.brandService.add(createBrandRequest);
	}

	/*@PutMapping("/update")
    public Result update(@RequestBody @Valid UpdateBrandRequest updateBrandRequest) {

		return  this.brandService.update(updateBrandRequest);
    }
	@DeleteMapping("/delete")
    public Result delete(@RequestBody @Valid DeleteBrandRequest deleteBrandRequest) {

		return  this.brandService.delete(deleteBrandRequest);
	}*/
	
	@GetMapping("/getall")
	public DataResult<List<ListBrandDto>> getAll() {

		return this.brandService.getAll();
	}
}
//response-request pattern
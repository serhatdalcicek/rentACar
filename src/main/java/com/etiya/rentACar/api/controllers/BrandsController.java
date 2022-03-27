package com.etiya.rentACar.api.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.etiya.rentACar.business.abstracts.BrandService;
import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;

//dış dünya ile iletişim kurar 
@RestController
@RequestMapping("/api/brands")
public class BrandsController {
	private BrandService brandService;

	// @Autowired
	public BrandsController(BrandService brandService) {
		this.brandService = brandService;
	}

	// veri tabanı nesnesini controllera taşımak yasak
	@PostMapping("/add")
	public void add(@RequestBody CreateBrandRequest createBrandRequest) {
		this.brandService.add(createBrandRequest);
	}
	
	@GetMapping("/getall")
	public List<ListBrandDto>getAll() {
		return this.brandService.getAll();
	}
}
//response-request pattern
package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.brandRequests.CreateBrandRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.entities.Brand;

public interface BrandService {
	
	

	List<ListBrandDto> getAll();
	
	
	void add(CreateBrandRequest createBrandRequest);
	void delete(Brand brand);
	void update(Brand brand);

}

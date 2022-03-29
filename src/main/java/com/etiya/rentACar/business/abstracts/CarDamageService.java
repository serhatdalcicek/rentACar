package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carDamageRequests.CreateCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.DeleteCarDamageRequest;
import com.etiya.rentACar.business.requests.carDamageRequests.UpdateCarDamageRequest;
import com.etiya.rentACar.business.responses.carDamageResponses.CarDamageDto;
import com.etiya.rentACar.business.responses.carDamageResponses.ListCarDamageDto;

public interface CarDamageService {
	
	CarDamageDto getById(int id);
	
	List<ListCarDamageDto> getAll();
	List<ListCarDamageDto> getAllByCarId(int carId);
	List<ListCarDamageDto> getAllPaged(int pageNo , int pageSize);
	List<ListCarDamageDto> getAllSorted(String option, String fields);

	
	void add(CreateCarDamageRequest createCarDamageRequest);
	void update(UpdateCarDamageRequest updateCarDamageRequest);
	void delete(DeleteCarDamageRequest deleteCarDamageRequest);

	
}
/*
void add(CreateCarDamageRequest createDamageRequest);

List<ListCarDamageDto> getAll();

List<ListCarDamageDto> getByCarId(int id);

List<ListCarDamageDto> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada
															// kaç tane olsuna göre yapılandırır.

List<ListCarDamageDto> getAllSorted(String option, String field); // sorted sıralı demektir.*/
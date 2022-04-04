package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.DeleteDamageRequest;
import com.etiya.rentACar.business.requests.damageRequests.UpdateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.DamageDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;

public interface DamageService {



	DamageDto getById(int id);

	DataResult<List<ListDamageDto>> getAll();
	DataResult<List<ListDamageDto>> getAllByCarId(int carId);
	DataResult<List<ListDamageDto>> getAllPaged(int pageNo, int pageSize);
	DataResult<List<ListDamageDto>> getAllSorted(String option ,String properties);


	Result add(CreateDamageRequest createDamageRequest);
	Result update(UpdateDamageRequest updateDamageRequest);
	Result delete(DeleteDamageRequest deleteDamageRequest);
	
}
/*
void add(CreateCarDamageRequest createDamageRequest);

List<ListCarDamageDto> getAll();

List<ListCarDamageDto> getByCarId(int id);

List<ListCarDamageDto> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada
															// kaç tane olsuna göre yapılandırır.

List<ListCarDamageDto> getAllSorted(String option, String field); // sorted sıralı demektir.*/
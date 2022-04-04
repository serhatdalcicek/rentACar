package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carRequests.*;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.entities.CarStates;

public interface CarService {



	Result updateCarState(UpdateCarStatesRequest updateCarStateRequest);
	void updateCarKilometer(UpdateKilometerRequest updateKilometerRequest);
	void updateCarCity(UpdateCarCityRequest updateCarCityRequest);

	CarDto getById(int carId);

	DataResult<List<ListCarDto>> getAll();
	DataResult<List<ListCarDto>> getAllByModelYear(int ModelYear);
	DataResult<List<ListCarDto>> getAllPaged(int pageNo, int pageSize);
	DataResult<List<ListCarDto>>getAllSorted();

	Result add(CreateCarRequest createCarRequest);
	Result update(UpdateCarRequest updateCarRequest);
	Result delete(DeleteCarRequest deleteCarRequest);

}

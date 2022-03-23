package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CarDao;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.Color;

@Service
public class CarManager implements CarService {

	private CarDao carDao;
	private ModelMapperService modelMapperService;
	
	public CarManager(CarDao carDao, ModelMapperService modelMapperService) {
		this.carDao = carDao;
		this.modelMapperService = modelMapperService;
	}
	
	
	@Override
	public void add(CreateCarRequest createCarRequest) {
       Car car = this.modelMapperService.forRequest().map(createCarRequest, Car.class);
       
       this.carDao.save(car);
	}


	@Override
	public List<ListCarDto> getAll() {
		  List<Car> cars = this.carDao.findAll();
	        List<ListCarDto> response = cars.stream().map(car -> this.modelMapperService.forDto()
	        		.map(car,ListCarDto.class)).collect(Collectors.toList());
	        return response;			
	}

}

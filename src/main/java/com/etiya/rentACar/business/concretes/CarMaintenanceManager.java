package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarMaintenanceService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.CreateCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.DeleteCarMaintenanceRequest;
import com.etiya.rentACar.business.requests.carMaintenanceRequests.UpdateCarMaintenanceRequest;
import com.etiya.rentACar.business.responses.carMaintenanceResponses.ListCarMaintenanceDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.CarMaintenanceDao;
import com.etiya.rentACar.entities.CarMaintenance;

@Service
public class CarMaintenanceManager implements CarMaintenanceService {

	private CarMaintenanceDao carMaintenanceDao;
	private ModelMapperService modelMapperService;
	private CarService carService;

	public CarMaintenanceManager(CarMaintenanceDao carMaintenanceDao, ModelMapperService modelMapperService, CarService carService) {
		
		this.carMaintenanceDao = carMaintenanceDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
	}

	
	@Override
	public void add(CreateCarMaintenanceRequest createMaintenanceRequest) {

		checkIfCarId(createMaintenanceRequest.getCarId());
		
		CarMaintenance carMaintenance = modelMapperService.forRequest()
				.map(createMaintenanceRequest, CarMaintenance.class);
		
		carMaintenanceDao.save(carMaintenance);
		
		
		
	}

	@Override
	public void update(UpdateCarMaintenanceRequest updateCarMaintenanceRequest) {
		
		CarMaintenance carMaintenance = this.modelMapperService.forRequest()
				.map(updateCarMaintenanceRequest, CarMaintenance.class);
	        
		this.carMaintenanceDao.save(carMaintenance);		
	}



	@Override
	public void delete(DeleteCarMaintenanceRequest deleteCarMaintenanceRequest) {
		
		this.carMaintenanceDao.deleteById(deleteCarMaintenanceRequest.getMaintenanceId());			
		
	}
	@Override
	public List<ListCarMaintenanceDto> getAll() {
		
		List<CarMaintenance> carMaintenances = this.carMaintenanceDao.findAll();
		
        List<ListCarMaintenanceDto> response = carMaintenances.stream()
                .map(carMaintenance -> modelMapperService.forDto()
                		.map(carMaintenance, ListCarMaintenanceDto.class))
                .collect(Collectors.toList());
       
        return response;
	}

	@Override
	public List<ListCarMaintenanceDto> getByCarId(int carId) {
		
		List<CarMaintenance> carMaintenances = this.carMaintenanceDao.getByCarId(carId);
		
        List<ListCarMaintenanceDto> response = carMaintenances.stream()
                .map(carMaintenance -> this.modelMapperService.forDto()
                        .map(carMaintenance, ListCarMaintenanceDto.class))
                .collect(Collectors.toList());
        
        return response;
	}


	private void checkIfCarId(int carId) {
		
		 if (carMaintenanceDao.existsMaintenanceByCarId(carId)) {
			 
	            throw new RuntimeException("Bu araç bakımda");
	        }		
	}
	
	


}

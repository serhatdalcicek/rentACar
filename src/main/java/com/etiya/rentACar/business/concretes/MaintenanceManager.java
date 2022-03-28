package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.requests.maintenanceRequests.UpdateMaintenanceRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.crossCuttingConcerns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.entities.Maintenance;

@Service
public class MaintenanceManager implements MaintenanceService {

	private MaintenanceDao maintenanceDao;
	private ModelMapperService modelMapperService;
	private CarService  carService;

	public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService, CarService carService) {
		this.maintenanceDao = maintenanceDao;
		this.modelMapperService = modelMapperService;
		this.carService = carService;
	}

	 @Override
	    public void add(CreateMaintenanceRequest createMaintenanceRequest) {//

	        checkIfCarId(createMaintenanceRequest.getCarId()); //
	        
	        Maintenance maintenance = modelMapperService.forRequest()
	                .map(createMaintenanceRequest, Maintenance.class);
	        maintenanceDao.save(maintenance);
	        
	        updateCarStatus(createMaintenanceRequest.getCarId());
	    }

	   @Override
	    public List<ListMaintenanceDto> getAll() {
		   
	        List<Maintenance> maintenances = this.maintenanceDao.findAll();
	        
	        List<ListMaintenanceDto> response = maintenances.stream()
	                .map(maintenance -> modelMapperService.forDto()
	                .map(maintenance, ListMaintenanceDto.class))
	                .collect(Collectors.toList());
	        return response;
	    }
	  

	   @Override
	    public List<ListMaintenanceDto> getByCarId(int id) {
		   
	        List<Maintenance> maintenances = this.maintenanceDao.getByCarId(id);
	        
	        List<ListMaintenanceDto> response = maintenances.stream()
	                .map(maintenance -> this.modelMapperService.forDto()
	                .map(maintenance, ListMaintenanceDto.class))
	                .collect(Collectors.toList());
	        return response;
	    }
	   @Override
	    public void update(UpdateMaintenanceRequest updateMaintenanceRequest) {

	        Maintenance maintenance=this.modelMapperService.forRequest().map(updateMaintenanceRequest,Maintenance.class);

	        this.maintenanceDao.save(maintenance);

	    }
	   private void checkIfExistsMaintenance(CreateMaintenanceRequest createMaintenanceRequest){
		   
	        ListCarDto listCarDto  = this.carService.getById(createMaintenanceRequest.getCarId());
	        
	        if(listCarDto.getStatusId()==2) throw new BusinessException("Bu araba servistedir.");
	    }



	   private void checkIfCarId(int carId) { 
		   
	        if (maintenanceDao.existsMaintenanceByCarId(carId)) { 

	            throw new RuntimeException("Bu araç bakımda");
	        }
	    }
	   private void updateCarStatus(int carId){
	        ListCarDto listCarDto  = this.carService.getById(carId);
	        UpdateCarRequest updateCarRequest=this.modelMapperService.forRequest().map(listCarDto,UpdateCarRequest.class);
	        updateCarRequest.setStatusId(2);

	        this.carService.updateStatus(updateCarRequest);
	    }
	   @Override
	    public List<ListMaintenanceDto> getById(int id) {

	        List<Maintenance> maintenances=this.maintenanceDao.getByCarId(id);

	        List<ListMaintenanceDto> responce=maintenances.stream()
	                .map(maintenance -> this.modelMapperService.forDto().map(maintenance,ListMaintenanceDto.class))
	                .collect(Collectors.toList());
	        return responce;

	    }
	

}

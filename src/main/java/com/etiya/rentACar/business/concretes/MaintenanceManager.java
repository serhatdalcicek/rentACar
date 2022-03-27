package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.MaintenanceService;
import com.etiya.rentACar.business.requests.maintenanceRequests.CreateMaintenanceRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.MaintenanceDao;
import com.etiya.rentACar.entities.Maintenance;
import com.etiya.rentACar.entities.Situations;

@Service
public class MaintenanceManager implements MaintenanceService {

	MaintenanceDao maintenanceDao;
	ModelMapperService modelMapperService;

	public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService) {
		this.maintenanceDao = maintenanceDao;
		this.modelMapperService = modelMapperService;
	}

	 @Override
	    public void add(CreateMaintenanceRequest createMaintenanceRequest, Situations situations) {

	        checkIfCarId(createMaintenanceRequest.getCarId(), situations);
	        Maintenance maintenance = modelMapperService.forRequest()
	                .map(createMaintenanceRequest, Maintenance.class);
	        maintenanceDao.save(maintenance);
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
	    public List<ListMaintenanceDto> getAllSituations(Situations situations) {
		   
	        List<Maintenance> maintenances = this.maintenanceDao.findAll();
	        
	        List<ListMaintenanceDto> response = maintenances.stream()
	                .filter(lista -> lista.getSituations() == situations)//filter = Bir listeyi bir veya birden çok parametreye göre kısıtlayabiliriz
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

	

	

	   private void checkIfCarId(int carId, Situations situations) {
		   
	        if (maintenanceDao.existsMaintenanceByCarId(carId) && situations == Situations.Available) {

	            throw new RuntimeException("Bu araç bakımda");
	        }
	    }


	

}

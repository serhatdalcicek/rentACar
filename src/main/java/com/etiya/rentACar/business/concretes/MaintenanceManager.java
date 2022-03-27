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

@Service
public class MaintenanceManager implements MaintenanceService {

	MaintenanceDao maintenanceDao;
	ModelMapperService modelMapperService;

	public MaintenanceManager(MaintenanceDao maintenanceDao, ModelMapperService modelMapperService) {
		this.maintenanceDao = maintenanceDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateMaintenanceRequest createMaintenanceRequest) {

		checkIfCarId(createMaintenanceRequest.getCarId());
		Maintenance maintenance = this.modelMapperService.forRequest().map(createMaintenanceRequest, Maintenance.class);
		maintenanceDao.save(maintenance);

	}

	@Override
	public List<ListMaintenanceDto> getAll() {
		List<Maintenance> maintenances = this.maintenanceDao.findAll();
		List<ListMaintenanceDto> response = maintenances.stream()
				.map(maintenance -> modelMapperService.forDto().map(maintenance, ListMaintenanceDto.class))
				.collect(Collectors.toList());
		return response;
	}

	@Override
	public List<ListMaintenanceDto> getByCarId(int id) {
		List<Maintenance> maintenances = this.maintenanceDao.getByCarId(id);
		List<ListMaintenanceDto> response = maintenances.stream()
				.map(maintenance -> this.modelMapperService.forDto().map(maintenances, ListMaintenanceDto.class))
				.collect(Collectors.toList());
		return response;
	}
	@Override
	public List<ListMaintenanceDto> getByStatusId(int id){
		
	List<Maintenance> maintenances = this.maintenanceDao.getByStatusId(id);
	
	List<ListMaintenanceDto> response = maintenances.stream()
			.map(maintenance -> this.modelMapperService.forDto()
					.map(maintenances, ListMaintenanceDto.class))
			.collect(Collectors.toList());
	return response;
		
	}
	private void checkIfCarId(int carId) {
		if (maintenanceDao.existsMaintenanceByCarId(carId)) {
			throw new RuntimeException("Maalesef bu araç bakımdadır");
		}
	}
}

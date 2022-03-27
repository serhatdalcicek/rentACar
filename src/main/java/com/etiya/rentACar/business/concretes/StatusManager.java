package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.StatusService;
import com.etiya.rentACar.business.requests.stateRequests.CreateStatusRequest;
import com.etiya.rentACar.business.responses.stateResponses.ListStatusDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.StatusDao;
import com.etiya.rentACar.entities.Status;



@Service //Sen bir service sınıfısın. Bunu anlatmak için tanımlanır.
public class StatusManager implements StatusService{

	
	StatusDao statusDao;
	ModelMapperService modelMapperService;
	
	
	public StatusManager(StatusDao statusDao, ModelMapperService modelMapperService) {
	
		this.statusDao = statusDao;
		this.modelMapperService = modelMapperService;
	}





	@Override
	public void add(CreateStatusRequest createStatusRequest) {		
		
		Status status=modelMapperService.forRequest().map(createStatusRequest, Status.class);
		
		statusDao.save(status);
		
		
		
	}


	@Override
	public List<ListStatusDto> getAll() {
		
		List<Status> statuses = this.statusDao.findAll();
		
		List<ListStatusDto> response = statuses.stream()
				
				.map(status -> modelMapperService.forDto().map(status, ListStatusDto.class))
				.collect(Collectors.toList());
		
		return response;
	}
	@Override
	public List<ListStatusDto> getByStatusId(int id) {

		List<Status> statuses = this.statusDao.getByStatusId(id);

		List<ListStatusDto> response = statuses.stream()
				.map(status -> this.modelMapperService.forDto().map(statuses, ListStatusDto.class))
				.collect(Collectors.toList());
		
		return response;

	}

}

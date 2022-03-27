package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.StatusService;
import com.etiya.rentACar.business.requests.statusRequests.CreateStatusRequest;
import com.etiya.rentACar.business.responses.statusResponses.ListStatusDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.StatusDao;
import com.etiya.rentACar.entities.Status;

@Service //Sen bir service sınıfısın. Bunu anlatmak için tanımlanır.
public class StatusManager implements StatusService {

	private StatusDao statusDao;
	private ModelMapperService modelMapperService;

	public StatusManager(StatusDao statusDao, ModelMapperService modelMapperService) {
		this.statusDao = statusDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateStatusRequest createStatusRequest) {

		Status status = this.modelMapperService.forRequest().map(createStatusRequest, Status.class);
		
		this.statusDao.save(status);
	}

	@Override
	public List<ListStatusDto> getAll() {

		List<Status> statuses = this.statusDao.findAll();

		List<ListStatusDto> response = statuses.stream()

				.map(status -> this.modelMapperService.forDto().map(status, ListStatusDto.class))
				.collect(Collectors.toList());

		return response;
	}

	/*@Override
	public List<ListStatusDto> getByStatusName(String name) {
		
		List<Status> statuses = statusDao.getByStatusName(name);
		List<ListStatusDto> response = statuses.stream().map(status -> modelMapperService.forDto()
				.map(status, ListStatusDto.class))
				.collect(Collectors.toList());
		
		
		return response;
	}*/

}

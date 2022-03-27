package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.stateRequests.CreateStatusRequest;
import com.etiya.rentACar.business.responses.stateResponses.ListStatusDto;

public interface StatusService {
	
	void add(CreateStatusRequest createStatusRequest);

	List<ListStatusDto> getAll();

	List<ListStatusDto> getByStatusId(int id);
	
	

}

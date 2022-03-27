package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.statusRequests.CreateStatusRequest;
import com.etiya.rentACar.business.responses.statusResponses.ListStatusDto;

public interface StatusService {
	
	void add(CreateStatusRequest createStatusRequest);

	List<ListStatusDto> getAll();
	
	/*List<ListStatusDto> getByStatusName(String name);*/

}

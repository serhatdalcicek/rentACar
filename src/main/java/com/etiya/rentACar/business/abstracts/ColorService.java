package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.entities.Color;

public interface ColorService {
	void add(CreateColorRequest createColorRequest);
	
	void delete(Color color);
	
    void update(Color color);
    
	List<ListColorDto> getAll();

	List<ListColorDto> getAllPaged(int pageNo, int pageSize);

}

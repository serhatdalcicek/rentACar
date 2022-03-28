package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

public interface CarService {
	void add(CreateCarRequest createCarRequest);
	
	void update(UpdateCarRequest updateCarRequest);
	
	void updateStatus(UpdateCarRequest updateCarRequest);
    

	List<ListCarDto> getAll();

	List<ListCarDto> getAllByModelYear(int modelYear);

	List<ListCarDto> getAllPage(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç											// tane olsuna göre yapılandırır.

	List<ListCarDto> getAllSorted(); // sorted sıralı demektir.
    
	List<ListCarDto> getByCarId(int id);

	ListCarDto getById(int id);


	//ListCarDto getByCarId(int carId);

}

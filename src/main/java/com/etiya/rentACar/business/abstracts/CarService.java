package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

public interface CarService {

    
    CarDto getById(int id);
    
	List<ListCarDto> getAll();
	List<ListCarDto> getAllByModelYear(int modelYear);
	List<ListCarDto> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.
	List<ListCarDto> getAllSorted(String option, String fields); // sorted sıralı demektir.
	//List<ListCarDto> getByCarId(int id);
	
	
	
	
	void add(CreateCarRequest createCarRequest);
	void update(UpdateCarRequest updateCarRequest);
	void delete(DeleteCarRequest deleteCarRequest);



//	ListCarDto getById(int id);


	//ListCarDto getByCarId(int carId);

}

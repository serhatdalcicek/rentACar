package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.carRequests.CreateCarRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;

public interface CarService {
 void add(CreateCarRequest createCarRequest);

List<ListCarDto> getAll();

List<ListCarDto> getAllByModelYear(int modelYear);

List<ListCarDto> getAllPage(int pageNo,int pageSize); //hangi sayfa ve bir sayfada kaç tane olsun .. sayfada kaç tane olsuna göre yapılandırır.

List<ListCarDto> getAllSorted(); //sorted sıralı demektir.

}

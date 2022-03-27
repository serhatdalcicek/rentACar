package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;

public interface DamageService {
	void add(CreateDamageRequest createDamageRequest);

	List<ListDamageDto> getAll();

	List<ListDamageDto> getByCarId(int id);

	List<ListDamageDto> getAllPaged(int pageNo, int pageSize); // hangi sayfa ve bir sayfada kaç tane olsun .. sayfada
																// kaç tane olsuna göre yapılandırır.

	List<ListDamageDto> getAllSorted(String option, String field); // sorted sıralı demektir.

}

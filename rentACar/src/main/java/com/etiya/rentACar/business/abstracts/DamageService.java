package com.etiya.rentACar.business.abstracts;

import java.util.List;

import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.entities.Damage;

public interface DamageService {
	 void add(CreateDamageRequest createDamageRequest);
	 
	 List<ListDamageDto> getAll();
	 
   List<ListDamageDto> getByCarId(int id);
}

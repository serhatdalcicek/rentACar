package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.DamageService;
import com.etiya.rentACar.business.requests.damageRequests.CreateDamageRequest;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.DamageDao;
import com.etiya.rentACar.entities.Damage;

@Service
public class DamageManager implements DamageService {
	
	private DamageDao damageDao;
	private ModelMapperService modelMapperService;

	public DamageManager(DamageDao damageDao, ModelMapperService modelMapperService) {
		this.damageDao = damageDao;
		this.modelMapperService = modelMapperService;
	}

	@Override
	public void add(CreateDamageRequest createDamageRequest) {
		
		Damage damage = this.modelMapperService.forRequest()
				.map(createDamageRequest, Damage.class);
		// damage.setId(0); //id bu şekilde sıfırlanabilir.

		this.damageDao.save(damage);

	}

	@Override
	public List<ListDamageDto> getAll() {
		
		List<Damage> damages = this.damageDao.findAll();
		
		List<ListDamageDto> response = damages.stream()
				
				.map(damage -> this.modelMapperService.forDto()
				.map(damage, ListDamageDto.class))
				.collect(Collectors.toList());
		
		return response;
	}

	@Override

	public List<ListDamageDto> getByCarId(int id) {
		
		List<Damage> damages = this.damageDao.getByCarId(id);
		
		List<ListDamageDto> response = damages.stream()
				
				.map(damage -> this.modelMapperService.forDto()
				.map(damage, ListDamageDto.class))
				.collect(Collectors.toList());

		return response;
	}

	@Override
	public List<ListDamageDto> getAllPaged(int pageNo, int pageSize) {

		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

		List<Damage> damages = this.damageDao.findAll(pageable).getContent();

		List<ListDamageDto> response = damages.stream()

				.map(damage -> this.modelMapperService.forDto()
				.map(damage, ListDamageDto.class))
				.collect(Collectors.toList());
		
		return response;
	}

	@Override
	public List<ListDamageDto> getAllSorted(String option,String field) { //sort metodu ile option ve field ile sıralamyı kullanıcıya girmesini belirtir

		Sort sort = Sort.by(Sort.Direction.valueOf(option),field);   //valueOf kullanıma göre sıralama yapar

		List<Damage> damages = this.damageDao.findAll(sort);

		List<ListDamageDto> response = damages.stream()

				.map(damage -> this.modelMapperService.forDto()
				.map(damage, ListDamageDto.class))
				.collect(Collectors.toList());
		
		return response;
	}

}

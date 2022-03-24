package com.etiya.rentACar.business.concretes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.etiya.rentACar.business.abstracts.ColorService;
import com.etiya.rentACar.business.requests.colorRequests.CreateColorRequest;
import com.etiya.rentACar.business.responses.brandResponses.ListBrandDto;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.colorResponses.ListColorDto;
import com.etiya.rentACar.business.responses.damageResponses.ListDamageDto;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.dataAccess.abstracts.ColorDao;
import com.etiya.rentACar.entities.Brand;
import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.Color;
import com.etiya.rentACar.entities.Damage;

@Service
public class ColorManager implements ColorService {
	private ColorDao colorDao;
	private ModelMapperService modelMapperService;

	

	public ColorManager(ColorDao colorDao, ModelMapperService modelMapperService) {
		this.colorDao = colorDao;
		this.modelMapperService = modelMapperService;
	}



	@Override
	public void add(CreateColorRequest createColorRequest) {
		
		if(this.colorDao.getByName(createColorRequest.getColorName()).size()==0){
			
            Color color=this.modelMapperService.forRequest()
            .map(createColorRequest,Color.class);
            
            colorDao.save(color);
		}
	}



	@Override
	public List<ListColorDto> getAll() {
		
		  List<Color> colors = this.colorDao.findAll();
		  
	        List<ListColorDto> response = colors.stream()
	        		
	        		.map(color -> this.modelMapperService.forDto()
	        		.map(color,ListColorDto.class)).collect(Collectors.toList());
	       
	        return response;
	}
	@Override
	public List<ListColorDto> getAllPaged(int pageNo, int pageSize) { //sayfalar
		
       Pageable pageable = PageRequest.of(pageNo-1, pageSize);
       
	List<Color> colors = this.colorDao.findAll(pageable).getContent();
	
	 List<ListColorDto> response = colors.stream()
			 
			 .map(color -> this.modelMapperService.forDto()
			 .map(color,ListColorDto.class)).collect(Collectors.toList());
       
	 return response;
	}



	}



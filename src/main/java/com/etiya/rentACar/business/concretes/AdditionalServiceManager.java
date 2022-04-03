package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.AdditionalServiceService;
import com.etiya.rentACar.business.constants.BusinessMessages;
import com.etiya.rentACar.business.requests.additionalServiceRequests.CreateAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.DeleteAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.additionalServiceRequests.UpdateAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.additionalService.ListAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.AdditionalServiceDao;
import com.etiya.rentACar.entities.AdditionalService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdditionalServiceManager implements AdditionalServiceService {
    private AdditionalServiceDao additionalServiceDao;
    private ModelMapperService modelMapperService;

    public AdditionalServiceManager(AdditionalServiceDao additionalServiceDao, ModelMapperService modelMapperService) {
        this.additionalServiceDao = additionalServiceDao;
        this.modelMapperService = modelMapperService;
    }

    @Override
    public Result add(CreateAdditionalServiceRequest createAdditionalServiceRequest) {
        AdditionalService result = this.modelMapperService.forRequest().map(createAdditionalServiceRequest,AdditionalService.class);
        this.additionalServiceDao.save(result);

        return new SuccessResult(BusinessMessages.AdditionalServiceMessage.ADDITIONAL_SERVICES_ADD);
    }

    @Override
    public Result delete(DeleteAdditionalServiceRequest deleteAdditionalServiceRequest) {
        int additionalServiceRequestId = deleteAdditionalServiceRequest.getId();
        this.additionalServiceDao.deleteById(additionalServiceRequestId);
        return new SuccessResult(BusinessMessages.AdditionalServiceMessage.ADDITIONAL_SERVICES_DELETE);
    }


    @Override
    public Result update(UpdateAdditionalServiceRequest updateAdditionalServiceRequest) {
        AdditionalService result = this.modelMapperService.forRequest().map(updateAdditionalServiceRequest, AdditionalService.class);
        this.additionalServiceDao.save(result);
        return new SuccessResult(BusinessMessages.AdditionalServiceMessage.ADDITIONAL_SERVICES_UPDATE);
    }
    @Override
    public DataResult<List<ListAdditionalServiceDto>> getAll() {
        List<AdditionalService> result=this.additionalServiceDao.findAll();
        List<ListAdditionalServiceDto> response=result.stream().map(additionalService -> modelMapperService.forDto()
                .map(additionalService,ListAdditionalServiceDto.class)).collect(Collectors.toList());
        return new SuccessDataResult<List<ListAdditionalServiceDto>>(response);
    }

}

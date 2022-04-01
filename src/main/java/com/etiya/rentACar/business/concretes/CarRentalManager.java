package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarRentalService;
import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.etiya.rentACar.business.constants.BusinessMessages;
import com.etiya.rentACar.business.requests.carRentalRequests.CreateCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.DeleteCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.ReturnCarRentalRequest;
import com.etiya.rentACar.business.requests.carRentalRequests.UpdateCarRentalRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStatesRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.CreateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.carRentalResponses.ListCarRentalDto;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.core.crossCuttingConserns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.CarRentalDao;
import com.etiya.rentACar.entities.CarRental;
import com.etiya.rentACar.entities.CarStates;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarRentalManager implements CarRentalService {

    private CarRentalDao carRentalDao;
    private ModelMapperService modelMapperService;
    private CarService carService;
    private OrderedAdditionalServiceService orderedAdditionalServiceService;


    public CarRentalManager(CarRentalDao carRentalDao, ModelMapperService modelMapperService, CarService carService, OrderedAdditionalServiceService orderedAdditionalServiceService) {
        this.carRentalDao = carRentalDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
        this.orderedAdditionalServiceService = orderedAdditionalServiceService;
    }

    @Override
    public Result add(CreateCarRentalRequest createCarRentalRequest) {
        int carId = createCarRentalRequest.getCarId();
        checkIfRentalExists(carId);
        CarRental result = this.modelMapperService.forRequest().map(createCarRentalRequest, CarRental.class);
        this.carRentalDao.save(result);
        // rented
        UpdateCarStatesRequest updateCarStatesRequest = new UpdateCarStatesRequest();
        updateCarStatesRequest.setCarId(carId);
        updateCarStatesRequest.setCarStateName(CarStates.Rented);
        this.carService.updateCarStates(updateCarStatesRequest);
        //state güncelleme

        // rental   createRentalRequest.getId()
        // createRentalRequest.getAdditionalServiceId()
        // List<CreateOrderedAdditionalServiceRequest> result1 = this.modelMapperService.forRequest().map(createRentalRequest,CreateOrderedAdditionalServiceRequest.class);
        //CreateOrderedAdditionalServiceRequest deneme = new CreateOrderedAdditionalServiceRequest();
        //[1,2,3]
        int carRentalId = result.getId();
        CreateOrderedAdditionalServiceRequest deneme = new CreateOrderedAdditionalServiceRequest();
        deneme.setCarRentalId(carRentalId);

        for (int item : createCarRentalRequest.getAdditionalServiceId()) {

            deneme.setAdditionalServiceId(item);
            this.orderedAdditionalServiceService.add(deneme);
        }

        //
        return new SuccessResult(BusinessMessages.CarRentalMessage.CAR_RENTAL_ADD);
    }

    @Override
    public Result update(UpdateCarRentalRequest updateCarRentalRequest) {

        CarRental carRental = this.modelMapperService.forRequest()

                .map(updateCarRentalRequest, CarRental.class);

        this.carRentalDao.save(carRental);

        return new SuccessResult(BusinessMessages.CarRentalMessage.CAR_RENTAL_UPDATE);
    }

    @Override
    public Result delete(DeleteCarRentalRequest deleteCarRentalRequest) {

        this.carRentalDao.deleteById(deleteCarRentalRequest.getRentalId());

        return new SuccessResult(BusinessMessages.CarRentalMessage.CAR_RENTAL_DELETE);
    }


    @Override
    public DataResult<List<ListCarRentalDto>> getAll() {

        List<CarRental> carRentals = this.carRentalDao.findAll();

        List<ListCarRentalDto> response = carRentals.stream()

                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }

    @Override
    public DataResult<List<ListCarRentalDto>> getAllPaged(int pageNo, int pageSize) {

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize);

        List<CarRental> carRentals = this.carRentalDao.findAll(pageable).getContent();

        List<ListCarRentalDto> response = carRentals.stream()

                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }

    @Override
    public DataResult<List<ListCarRentalDto>> getAllSorted(String option, String fields) {

        Sort sort = Sort.by(Sort.Direction.valueOf(option), fields);

        List<CarRental> carRentals = this.carRentalDao.findAll(sort);

        List<ListCarRentalDto> response = carRentals.stream()

                .map(carRental -> this.modelMapperService.forDto()
                        .map(carRental, ListCarRentalDto.class))
                .collect(Collectors.toList());

        return new SuccessDataResult<List<ListCarRentalDto>>(response);
    }

    @Override
    public Result ReturnCarRental(ReturnCarRentalRequest returnCarRentalRequest) {
        //checkIfRentalIdExists(returnRentalRequest.getId());
        CarRental result = this.carRentalDao.getById(returnCarRentalRequest.getId());
        UpdateCarStatesRequest updateCarStateRequest = new UpdateCarStatesRequest();
        updateCarStateRequest.setCarId(returnCarRentalRequest.getCarId());
        updateCarStateRequest.setCarStateName(CarStates.Available);
        this.carService.updateCarStates(updateCarStateRequest);
        this.carRentalDao.save(result);
        return new SuccessResult(BusinessMessages.CarRentalMessage.CAR_RENTAL_NOT_ID);
    }



    private void checkIfRentalExists(int carId) {
        CarDto result = this.carService.getById(carId);
        if (result.getCarStateName() != CarStates.Available) {
            throw new BusinessException(BusinessMessages.CarRentalMessage.CAR_NOT_AVAILABLE);
        }

    }


    }



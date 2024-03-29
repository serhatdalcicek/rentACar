package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.CarService;
import com.etiya.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.etiya.rentACar.business.abstracts.RentalService;
import com.etiya.rentACar.business.constants.BusinessMessages;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarCityRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarStatesRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateKilometerRequest;
import com.etiya.rentACar.business.requests.rentalRequests.CreateRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.DeleteRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.ReturnRentalRequest;
import com.etiya.rentACar.business.requests.rentalRequests.UpdateRentalRequest;
import com.etiya.rentACar.business.responses.carResponses.CarDto;
import com.etiya.rentACar.business.responses.rentalResponses.ListRentalDto;
import com.etiya.rentACar.business.responses.rentalResponses.RentalDto;
import com.etiya.rentACar.core.crossCuttingConserns.exceptionHandling.BusinessException;
import com.etiya.rentACar.core.utilities.mapping.ModelMapperService;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import com.etiya.rentACar.core.utilities.results.SuccessDataResult;
import com.etiya.rentACar.core.utilities.results.SuccessResult;
import com.etiya.rentACar.dataAccess.abstracts.RentalDao;
import com.etiya.rentACar.entities.CarStates;
import com.etiya.rentACar.entities.Rental;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class RentalManager implements RentalService {

    private RentalDao rentalDao;
    private ModelMapperService modelMapperService;
    private CarService carService;
    private OrderedAdditionalServiceService orderedAdditionalServiceService;

    public RentalManager(RentalDao rentalDao, ModelMapperService modelMapperService, CarService carService, OrderedAdditionalServiceService orderedAdditionalServiceService) {
        this.rentalDao = rentalDao;
        this.modelMapperService = modelMapperService;
        this.carService = carService;
        this.orderedAdditionalServiceService = orderedAdditionalServiceService;
    }

    @Override
    public DataResult <Rental>add(CreateRentalRequest createRentalRequest) {

        int carId = createRentalRequest.getCarId();
        checkIfCarState(carId);


        Rental result = this.modelMapperService.forRequest()
                .map(createRentalRequest, Rental.class);

        CarDto car = this.carService.getById(carId);
        result.setBeforeRentKilometer(car.getKilometer());
        this.rentalDao.save(result);



        updateCarCity(carId,createRentalRequest.getReturnCityId());
        CarStates status = CarStates.Rented;
        updateCarState(carId, status);

        return new SuccessDataResult<Rental>(result,BusinessMessages.RentalMessages.RENTAL_ADD);
    }

    @Override
    public Result update(UpdateRentalRequest updateRentalRequest) {

        Rental result = this.modelMapperService.forRequest().map(updateRentalRequest, Rental.class);

        this.rentalDao.save(result);

        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_UPDATE);
    }

    @Override
    public Result delete(DeleteRentalRequest deleteRentalRequest) {

        int rentalId = deleteRentalRequest.getId();

        this.rentalDao.deleteById(rentalId);

        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_DELETED);
    }


    public Result returnRental(ReturnRentalRequest returnRentalRequest) {

        checkIfRentalIdExists(returnRentalRequest.getId());

        Rental result = this.rentalDao.getById(returnRentalRequest.getId());

        result.setReturnDate(returnRentalRequest.getReturnDate());

        result.setBeforeRentKilometer(returnRentalRequest.getAfterRentKilometer());

        this.rentalDao.save(result);


        CarStates states = CarStates.Available;

        int carId = returnRentalRequest.getCarId();

        int returnCıtyId = returnRentalRequest.getReturnCityId();

        updateCarKilometer(returnRentalRequest);

        updateCarState(carId, states);

        updateCarCity(carId, returnCıtyId);

        return new SuccessResult(BusinessMessages.RentalMessages.RENTAL_RETURNED);
    }

    @Override
    public RentalDto getById(int rentalId) {

        Rental rental = this.rentalDao.getById(rentalId);

        RentalDto rentalDto = this.modelMapperService.forDto().map(rental, RentalDto.class);

        return rentalDto;
    }

    private void updateCarKilometer(ReturnRentalRequest returnRentalRequest) {

        double startCarKilometer = returnRentalRequest.getAfterRentKilometer();

        int carId = returnRentalRequest.getCarId();

        UpdateKilometerRequest updateKilometerRequest = new UpdateKilometerRequest();

        updateKilometerRequest.setId(carId);

        updateKilometerRequest.setKilometer(startCarKilometer);

        this.carService.updateCarKilometer(updateKilometerRequest);
    }

    @Override
    public DataResult<List<ListRentalDto>> getAll() {

        List<Rental> results = this.rentalDao.findAll();

        List<ListRentalDto> response = results.stream().map(rental -> modelMapperService.forDto()

                .map(rental, ListRentalDto.class)).collect(Collectors.toList());

        return new SuccessDataResult<List<ListRentalDto>>(response);
    }


    private void checkIfCarState(int carId) {

        CarDto result = this.carService.getById(carId);

        if (result.getCarStateName() != CarStates.Available) {

            throw new BusinessException(BusinessMessages.RentalMessages.CAR_NOT_AVAILABLE);
        }

    }

    private void checkIfRentalIdExists(int rentalId) {

        if (!this.rentalDao.existsById(rentalId)) {

            throw new BusinessException(BusinessMessages.RentalMessages.RENTAL_NOT_EXIST);
        }
    }

    private void updateCarState(int carId, CarStates status) {

        UpdateCarStatesRequest updateCarStatesRequest = new UpdateCarStatesRequest();

        updateCarStatesRequest.setCarId(carId);

        updateCarStatesRequest.setCarStateName(status);

        this.carService.updateCarStates(updateCarStatesRequest);

    }

    private void updateCarCity(int carId, int cityId) {

        UpdateCarCityRequest updateCarCityRequest = new UpdateCarCityRequest();

        updateCarCityRequest.setId(carId);

        updateCarCityRequest.setCityId(cityId);

        this.carService.updateCarCity(updateCarCityRequest);
    }

    /*private void createOrderedAdditionalService(int rentalId, List<Integer> additionalServicesId) {

        CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest = new CreateOrderedAdditionalServiceRequest();

        for (int additionalServiceId : additionalServicesId) {

            createOrderedAdditionalServiceRequest.setRentalId(rentalId);

            createOrderedAdditionalServiceRequest.setAdditionalServiceId(additionalServiceId);

            this.orderedAdditionalServiceService.add(createOrderedAdditionalServiceRequest);
        }*/
    }





package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.etiya.rentACar.business.requests.carRequests.DeleteCarRequest;
import com.etiya.rentACar.business.requests.carRequests.UpdateCarRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.CreateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.DeleteOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.UpdateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.business.responses.carResponses.ListCarDto;
import com.etiya.rentACar.business.responses.orderedAdditionalServiceResponses.ListOrderedAdditionalServiceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orderedAdditionalServices")
public class OrderedAdditionalServicesController {
    private OrderedAdditionalServiceService orderedAdditionalServiceService;

    public OrderedAdditionalServicesController(OrderedAdditionalServiceService orderedAdditionalServiceService) {
        this.orderedAdditionalServiceService = orderedAdditionalServiceService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest){
        return this.orderedAdditionalServiceService.add(createOrderedAdditionalServiceRequest);
    }

    @DeleteMapping("/delete")
    public  Result delete(@RequestBody DeleteOrderedAdditionalServiceRequest deleteOrderedAdditionalServiceRequest){
        return  this.orderedAdditionalServiceService.delete(deleteOrderedAdditionalServiceRequest);
    }

    @PutMapping ("/update")
    public Result update(@RequestBody UpdateOrderedAdditionalServiceRequest updateOrderedAdditionalServiceRequest){
        return this.orderedAdditionalServiceService.update(updateOrderedAdditionalServiceRequest);
    }
    @GetMapping("/getall")
    public DataResult<List<ListOrderedAdditionalServiceDto>> getAll() {
        return this.orderedAdditionalServiceService.getAll();
    }
}
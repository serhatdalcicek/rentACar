package com.etiya.rentACar.business.concretes;

import com.etiya.rentACar.business.abstracts.OrderedAdditionalServiceService;
import com.etiya.rentACar.business.requests.orderedAdditionalServiceRequest.CreateOrderedAdditionalServiceRequest;
import com.etiya.rentACar.core.utilities.results.Result;
import org.springframework.stereotype.Service;

@Service
public class OrderedAdditionalServiceManager implements OrderedAdditionalServiceService {
    @Override
    public Result add(CreateOrderedAdditionalServiceRequest createOrderedAdditionalServiceRequest) {
        return null;
    }
}

package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.PaymentService;
import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import com.etiya.rentACar.business.responses.maintenanceResponses.ListMaintenanceDto;
import com.etiya.rentACar.core.utilities.results.DataResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentsController {
    private PaymentService paymentService;

    public PaymentsController(PaymentService paymentService) {
        this.paymentService = paymentService;

    }
        @PostMapping("/add")
        public void add (@RequestBody @Valid CreatePaymentRequest createPaymentRequest){
            this.paymentService.add(createPaymentRequest);

            @GetMapping("/getAll")
            public DataResult<List<ListMaintenanceDto>> getAll() {
                return this.maintenanceService.getAll();
            }


    }
}
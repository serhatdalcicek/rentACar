package com.etiya.rentACar.api.controllers;

import com.etiya.rentACar.business.abstracts.PaymentService;
import com.etiya.rentACar.business.requests.paymentRequests.CreatePaymentRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

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


    }
}
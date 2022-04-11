package com.etiya.rentACar.core.adapters;

import com.etiya.rentACar.core.outServices.HalkBankPosService;
import com.etiya.rentACar.entities.CreditCard;
import org.springframework.stereotype.Service;


@Service
public class HalkBankPosServiceAdapter implements PosService{

    private HalkBankPosService halkBankPosService;

    public HalkBankPosServiceAdapter(HalkBankPosService halkBankPosService) {
        this.halkBankPosService = halkBankPosService;
    }

    @Override
    public boolean makePayment(CreditCard creditCard) {
        return halkBankPosService.makePayment(creditCard.getCreditCardNo(),creditCard.getExpireDate(),creditCard.getCvv());
    }
}
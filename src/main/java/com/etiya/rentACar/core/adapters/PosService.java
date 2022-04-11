package com.etiya.rentACar.core.adapters;

import com.etiya.rentACar.entities.CreditCard;
import org.springframework.stereotype.Service;

@Service
public interface PosService {
    boolean makePayment(CreditCard creditCard);
}

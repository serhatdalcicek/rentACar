package com.etiya.rentACar.business.requests.rentalRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnRentalRequest {

    private int id;

    private int carId;

    private int returnCityId;

    private double endKilometer;

    public LocalDate returnDate;

}
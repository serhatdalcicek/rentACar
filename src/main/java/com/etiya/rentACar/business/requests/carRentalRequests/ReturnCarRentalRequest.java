package com.etiya.rentACar.business.requests.carRentalRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReturnCarRentalRequest {

    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int customerId;

    private int carId;

    private int rentCityId;

    private int returnCityId;

    private double dailyPrice;


}
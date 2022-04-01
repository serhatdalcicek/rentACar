package com.etiya.rentACar.business.requests.carRentalRequests;

import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.Customer;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRentalRequest {

    private int id;

    private LocalDate rentDate;

    private LocalDate returnDate;

    private int customerId;

    private int returnCityId;

    private int rentCityId;

    private int carId;

    private double dailyPrice;

}

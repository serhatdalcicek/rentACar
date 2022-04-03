package com.etiya.rentACar.business.responses.carRentalResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarRentalDto {

    private int id;

    private int carId;

    private int customerId;

    private String carDescription;

    private LocalDate rentDate;

    private LocalDate returnDate;
}

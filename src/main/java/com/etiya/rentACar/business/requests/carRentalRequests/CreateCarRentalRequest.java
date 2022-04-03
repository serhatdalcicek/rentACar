package com.etiya.rentACar.business.requests.carRentalRequests;

import com.etiya.rentACar.entities.Car;
import com.etiya.rentACar.entities.CarStates;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCarRentalRequest {

    @JsonIgnore
    private int id;
    @NotNull
    private LocalDate rentDate;
    @NotNull
    private LocalDate returnDate;

    private double dailyPrice;

    @NotNull
    private int customerId;
    @NotNull
    private int carId;
    @NotNull
    private int rentCityId;
    @NotNull
    private int returnCityId;

    private int [] additionalServiceId;
}


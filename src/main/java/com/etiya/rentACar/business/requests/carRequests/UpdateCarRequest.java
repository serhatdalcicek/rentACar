package com.etiya.rentACar.business.requests.carRequests;


import com.etiya.rentACar.entities.CarStates;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCarRequest {

    private int id;

    private double dailyPrice;

    private String description;

    private int modelYear;

    private int cityId;

    private int colorId;

    private int brandId;

    private CarStates carStateName;

    private double kilometer;




}


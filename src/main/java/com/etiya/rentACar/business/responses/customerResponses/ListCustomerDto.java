package com.etiya.rentACar.business.responses.customerResponses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ListCustomerDto {

    private int id;

    private String firstName;

    private String lastName;

    private String nationalIdentity;
}


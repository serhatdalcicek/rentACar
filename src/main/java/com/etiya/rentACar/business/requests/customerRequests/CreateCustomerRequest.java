package com.etiya.rentACar.business.requests.customerRequests;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreateCustomerRequest {

    @JsonIgnore
    private int id;

    private String firstName;

    private String lastName;

    @NotNull
    @Length(max = 11,min = 11)
    private String nationalIdentity;



}
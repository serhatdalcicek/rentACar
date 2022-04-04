package com.etiya.rentACar.business.requests.customerRequests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateCustomerRequest {

    private int id;

    private String firstName;

    private String lastName;
    @NotNull
    @Length(min = 11,max = 11)
    private String nationalIdentity;

}

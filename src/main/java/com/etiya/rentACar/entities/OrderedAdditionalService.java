package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ordered_additional_services")
public class OrderedAdditionalService { //sipariş edilen ek hizmetler

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne
    @JoinColumn(name = "car_rental_id")
    private CarRental carRental;

    @ManyToOne
    @JoinColumn(name = "additional_service_id")
    private AdditionalService additionalService;


}

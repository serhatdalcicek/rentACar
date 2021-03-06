package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;


@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "rentCityId")
    private List<Rental> rentCityRentals;

    @OneToMany(mappedBy = "returnCityId")
    private List<Rental> returnCityRentals;

    @OneToMany(mappedBy = "city")
    private List<Car> cars;

}
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
@Table (name = "cities")
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "cityName")
    private String cityName;

    @OneToMany(mappedBy = "rentCityId")
    private List<CarRental> rentCityRentals;

    @OneToMany(mappedBy = "returnCityId")
    private List<CarRental> returnCityRentals;

    @OneToMany(mappedBy = "city")
    private List<Car> cars;

}

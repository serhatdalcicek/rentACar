package com.etiya.rentACar.entities;

import javax.persistence.*;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "cars")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "dailyPrice")
    private double dailyPrice;

    @Column(name = "description")
    private String description;

    @Column(name = "modelYear")
    private int modelYear;

    @Column(name = "car_state")
    private CarStates carState;

    @Column(name = "kilometer")
    private double kilometer;

    @ManyToOne
    @JoinColumn(name = "color_id")
    private Color color;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    @OneToMany(mappedBy = "car")
    private List<Damage> damages;

    @OneToMany(mappedBy = "car")
    private List<Maintenance> maintenances;

    @OneToMany(mappedBy = "car")
    private List<Rental> rentals;

    @ManyToOne
    @JoinColumn(name = "city_id")
    private City city;


}

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
	@Column(name = "carId")
	private int id;

	@Column(name = "dailyPrice")
	private double dailyPrice;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "modelYear")
	private int modelYear;

	@Column(name = "car_state")
	private CarStates carState;
	
	@ManyToOne
	@JoinColumn(name = "color_id")//renk id ye göre yapar
	private Color color;
	
	@ManyToOne //diğerlerine bağlama
	@JoinColumn(name="brand_id")
	private Brand brand;
	
	
	@OneToMany(mappedBy = "car")
	private List<CarDamage> cardamages;
	
	
	@OneToMany(mappedBy = "car")
    private List<CarMaintenance> carMaintanances;
	

	@ManyToOne
	@JoinColumn(name = "car_rental_id")
	private CarRental carRental;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private City city;


}

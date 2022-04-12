package com.etiya.rentACar.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "damages")
public class Damage {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@Column(name="id")
	private int id;

	@Column(name = "description")
	private String description;

	@Column(name = "date")
	private LocalDate date;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

}
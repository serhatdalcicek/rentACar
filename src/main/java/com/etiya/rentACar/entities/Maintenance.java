package com.etiya.rentACar.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "maintenances")
public class Maintenance {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // id üretmek için

	@Column(name = "maintananceId")
	private int maintananceId;

	@ManyToOne
	@JoinColumn(name = "car_id")
	private Car car;

	@Column(name = "dateAdded")
	private LocalDate dateAdded;

	@Column(name = "dateReturned")
	private LocalDate dateReturned;

	 @OneToOne
	 @JoinColumn(name="statusId")
	 private Status statusName;

}
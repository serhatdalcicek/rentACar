package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.CarRental;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRentalDao extends JpaRepository<CarRental , Integer> {
    List<CarRental> getAllByCarId(int carId);
}

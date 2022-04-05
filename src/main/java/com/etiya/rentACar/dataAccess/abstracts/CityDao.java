package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface CityDao extends JpaRepository<City, Integer> {

    boolean existsBrandByNameIgnoreCase(String cityName);
}

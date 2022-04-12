package com.etiya.rentACar.dataAccess.abstracts;

import com.etiya.rentACar.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarDao extends JpaRepository<Car, Integer> {
    
	List<Car> getByModelYear(int modelYear);
    
    List<Car> getByModelYearIn(List<Integer> modelYears);//HANGİ YILLARI EKLERSEN ONA GÖRE GETİRİR
    
    List<Car> getByModelYearAndDailyPrice(int modelYear, double dailyPrice);//model yılına göre günlük parası olanları gösterir
    
    List<Car> getByDescriptionContains(String description); //Gönderdiğin ifade geçen arabaları getirir conatins içermek






}

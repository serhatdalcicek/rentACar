package com.etiya.rentACar.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.etiya.rentACar.entities.Car;

@Repository

public interface CarDao extends JpaRepository<Car, Integer> {
    
	List<Car> getByModelYear(int modelYear);
    
    List<Car> getByModelYearIn(List<Integer> modelYears);//HANGİ YILLARI EKLERSEN ONA GÖRE GETİRİR
    
    List<Car> getByModelYearAndDailyPrice(int modelYear, double dailyPrice);//model yılına göre günlük parası olanları gösterir
    
    List<Car> getByDescriptionContains(String description); //descriptiona göre listeleme yapar
    
   // List<Car>getAllByStatus(CarStatus type); //bakımda olan araçlar listelenebilmelidir
    
    //Car getByCarId(int id);
}
//getByModelYear diyip parametre verdi
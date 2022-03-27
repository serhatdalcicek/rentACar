package com.etiya.rentACar;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class RentACarApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentACarApplication.class, args);

	}

	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}
//entites veri tabanı katmanı
//convantion isimlendirme
//bean = bir metodun üstüne bean eklersen çalışma anında onu çalıştır ve bellekte tut demek

//Arabalara ait hasar bilgilerini tutmak istiyoruz.
//id,carId,date,description tüm oluşmuş hasarları listeleme 
//getByCarId hasarları gösterme
//add,getAll, getByCarId 

//bir markanın bir den çok arabası olursa OneToMany
//bir arabanın bir markası olabileceği için ManyToOne
//manytomany çoka çok birden fazla araba birden fazla kaza gibi

//@JsonIgnore görünmez yapar 
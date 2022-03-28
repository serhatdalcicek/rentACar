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

	@Bean //İçinde sınıfların referanslarını tutar. Manuel olarak instance üretmemiz gereken sınıfları burada newleriz 

	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}
}

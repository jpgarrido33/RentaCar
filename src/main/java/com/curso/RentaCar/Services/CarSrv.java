package com.curso.RentaCar.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Model.Car;

public interface CarSrv {
	
Car createCar(CarDto carDto);
	
	Car getCar(Integer idCar);
	
	Page<Car> getListCar(Pageable pageable);
	
	void deleteCarService(Integer idCar);
	
	Car updateCar(Integer idCar, CarDto carDto);
	
	List<?> getListRentCar(Integer idCar, Pageable pageable);
	
	Car getCarProfit(LocalDate initDate, LocalDate finalDate);

}

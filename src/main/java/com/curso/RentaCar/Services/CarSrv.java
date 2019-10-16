package com.curso.RentaCar.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Model.Car;

public interface CarSrv {
	
	Car createCar(CarDto carDto);
	
	Car getCar(Integer idCar) throws CarNotFoundException;
	
	Page<Car> getListCar(Pageable pageable);
	
	void deleteCarService(Integer idCar) throws CarNotFoundException;
	
	Car updateCar(Integer idCar, CarDto carDto) throws CarNotFoundException;
	
	Car updateCreatelationUser(Integer idCar, Integer idUser) throws UserNotFoundException, CarNotFoundException;

	Double calcProfit(Integer idCar, String initDate, String finalDate) throws CarNotFoundException;
	
	}

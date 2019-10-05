package com.curso.RentaCar.Services;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Model.Car;

public class CarSrvImpl implements CarSrv  {

	@Override
	public Car createCar(CarDto carDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCar(Integer idCar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Car> getListCar(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteCarService(Integer idCar) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Car updateCar(Integer idCar, CarDto carDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getListRentCar(Integer idCar, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Car getCarProfit(LocalDate initDate, LocalDate finalDate) {
		// TODO Auto-generated method stub
		return null;
	}

}

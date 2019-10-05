package com.curso.RentaCar.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Repository.CarRepository;


@Service
public class CarSrvImpl implements CarSrv  {
	
	@Autowired private MapperServices<CarDto,Car> mapper;
	@Autowired private CarRepository carRepository;
	@Autowired private RentSrv rentSrv;
	
	@Override
	public Car createCar(CarDto carDto) {
		
		final Optional<Car> car = Optional.ofNullable(mapper.mapToEntity(carDto));
//			car.get().setBrandCar(carDto.getBrandCar());
//			car.get().setIdCar(carDto.getIdCar());
//			car.get().setModelCar(carDto.getModelCar());
			
			return carRepository.save(car.get());
	}

	@Override
	public Car getCar(Integer idCar) {
		
		return carRepository.findById(idCar).orElse(null);
				
	}
	@Override
	public Page<Car> getListCar(Pageable pageable) {

		return carRepository.findAll(pageable);
		
		}

	@Override
	public void deleteCarService(Integer idCar) {

		final Car car = this.getCar(idCar);
		
		carRepository.save(car);

		
	}

	@Override
	public Car updateCar(Integer idCar, CarDto carDto) {
		
		final Car car = this.getCar(idCar);
		
		return carRepository.save(car);
	}

	@Override
	public List<?> getListRentCar(Integer idCar, Pageable pageable) {
	
		final Car car = this.getCar(idCar);
		
		return rentSrv.getListRent(car.getRents());
		
	}

	//@Override
//	public Car getCarProfit(LocalDate initDate, LocalDate finalDate) {
//
//		return this.getCar(carRepository.findCarMostProfitableARangeOfDates(initDate, finalDate));
//	}

}

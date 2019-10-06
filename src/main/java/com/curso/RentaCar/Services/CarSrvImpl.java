package com.curso.RentaCar.Services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.UserNotFoundException;
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
	
			return carRepository.save(car.get());
	}

	@Override
	public Car getCar(Integer idCar) throws CarNotFoundException  {
		
		 return	Optional.ofNullable(carRepository.findById(idCar).get()).orElseThrow(CarNotFoundException::new);
		 
	}
	
	@Override
	public Page<Car> getListCar(Pageable pageable) {

		return carRepository.findAll(pageable);	
	}


	@Override
	public void deleteCarService(Integer idCar) throws CarNotFoundException {
		
		carRepository.delete(Optional.ofNullable(this.getCar(idCar)).orElseThrow(CarNotFoundException::new));

	}

	@Override
	public Car updateCar(Integer idCar, CarDto carDto) throws CarNotFoundException {
		Car car= this.getCar(idCar);
		car.setBrandCar(carDto.getBrandCar());
		car.setModelCar(carDto.getModelCar());
		return carRepository.save(car);
	}


	

}

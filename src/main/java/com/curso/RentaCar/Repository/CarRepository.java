package com.curso.RentaCar.Repository;

import java.time.LocalDate;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Model.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	
public Page<CarDto> findByModelCar(CarDto carDto, Pageable pageable);
public Page<Car> findByBrandCar(String brandCar,Car car, Pageable pageable);
public Page<Car> findByModelCarAndBrandCar(String modelCar,String brandCar, Car car, Pageable pageable);
//public Page<Car> findByModelCar(CarDto carDto, Pageable pageable);
}

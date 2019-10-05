package com.curso.RentaCar.Repository;

import java.time.LocalDate;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.curso.RentaCar.Model.Car;
@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

	Integer findCarMostProfitableARangeOfDates(LocalDate initDate, LocalDate finalDate);

}

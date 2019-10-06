package com.curso.RentaCar.Controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Services.CarSrv;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired private CarSrv carSrv;
	@Autowired private MapperServices<CarDto, Car> mapper;
	
	@GetMapping
	public Page<CarDto> getPageCar(@PageableDefault(page = 0, value = 10) Pageable pageable){
			
		return mapper.mapPageToDto(carSrv.getListCar(pageable));

	}
	
	@GetMapping("/{idCar}")
	public CarDto getCarId(@PathVariable("idCar") Integer idCar) throws CarNotFoundException  {
		return mapper.mapToDto(carSrv.getCar(idCar));
	}
	@PostMapping
	public CarDto newCar(@Valid @RequestBody CarDto carDto) {
			
		return mapper.mapToDto(carSrv.createCar(carDto));
	}
	
	@PutMapping("/{idCar}")
	public CarDto updateCar (@PathVariable("idCar") Integer idCar,@Valid @RequestBody CarDto carDto) throws CarNotFoundException {
		
		return mapper.mapToDto(carSrv.updateCar(idCar, carDto));
	
	}
		
	@DeleteMapping("/{idCar}")
	public void deleteCar(@PathVariable("idCar") Integer idCar) throws CarNotFoundException {
		carSrv.deleteCarService(idCar);
	}
	
	/*Falta Crear una funcion dado un coche entre unas fechas nos calcula el beneficio o ingreso que ganamos con ese coche.(+Test)
		(localTime) Cuanto coches ha alquilado un usuario.*/
}
	
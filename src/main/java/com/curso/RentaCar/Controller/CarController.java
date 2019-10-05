package com.curso.RentaCar.Controller;

import java.util.List;

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
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Services.CarSrv;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired private CarSrv carSrv;
	@Autowired private MapperServices<CarDto, Car> mapper;
	
	@GetMapping
	public Page<CarDto> getPageC(@PageableDefault(page = 0, value = 10) Pageable pageable){
			
		return mapper.mapPageToDto(carSrv.getListCar(pageable));

	}
	
	@GetMapping("/{id}")
	public CarDto getCarId(@PathVariable("id") Integer idCar)  {
		return mapper.mapToDto(carSrv.getCar(idCar));
	}
	@PostMapping
	public CarDto newCar( @RequestBody CarDto carDto) {
			
		return mapper.mapToDto(carSrv.createCar(carDto));
	}
	
	@PutMapping("/{id}")
	public CarDto updateCar (@PathVariable("id") Integer idCar,@RequestBody CarDto carDto) {
		
		return mapper.mapToDto(carSrv.updateCar(idCar, carDto));
	
	}
	@GetMapping ("/{id}/rent")
	public List<?> getListRentCar(@PageableDefault(page = 0, value = 10) Pageable pageable,
			@PathVariable("id") Integer idCar) {
		List<?> listCarRent = carSrv.getListRentCar(idCar, pageable);

		return listCarRent;
	}
	
	@DeleteMapping("/{id}")
	public void deleteCar(@PathVariable("id") Integer idCar) {
		carSrv.deleteCarService(idCar);
	}
	
	/*Falta Crear una funcion dado un coche entre unas fechas nos calcula el beneficio o ingreso que ganamos con ese coche.(+Test)
		(localTime) Cuanto coches ha alquilado un usuario.*/
}
	
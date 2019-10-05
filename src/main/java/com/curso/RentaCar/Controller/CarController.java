package com.curso.RentaCar.Controller;

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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Services.CarSrv;

@RestController
@RequestMapping("/car")
public class CarController {
	
	@Autowired private CarSrv carSrv;
	@Autowired private MapperServices mapper;
	
	@GetMapping
	public Page<CarDto> getAllCars(@PageableDefault(page = 0, value = 10) Pageable pageable){
			
		return <Page<CarDto>(
				mapper.mapPageToDto(carSrv.getListCar(pageable)));

}
}

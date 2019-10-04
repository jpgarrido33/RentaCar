package com.curso.RentaCar.Mapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Model.Car;

@Component
public class MapperSrvCarImpl implements MapperServices<CarDto,Car>{

	@Override
	public CarDto mapToDto(Car entity) {
		final CarDto carDto = new CarDto();
		if (Optional.ofNullable(entity).isPresent()) {
			carDto.setIdCar(entity.getIdCar());
			
		}
		return carDto;
	}

	@Override
	public Car mapToEntity(CarDto dto) {
		final Car car = new Car();
		if (Optional.ofNullable(dto).isPresent()) {
			car.setIdCar(dto.getIdCar());
			
		}
		return car;
	}

	@Override
	public List<CarDto> mapListToDto(List<Car> listCar) {
		final List<CarDto> listCarDto = new ArrayList<>();
		listCar.forEach((b)-> {
			final CarDto carDto = mapToDto(b);
			listCarDto.add(carDto);		
		});
		return listCarDto;		
	}

	@Override
	public Page<CarDto> mapPageToDto(Page<Car> pageEntity) {
		return pageEntity.map(b-> mapToDto(b));
	}
}


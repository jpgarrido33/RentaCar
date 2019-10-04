package com.curso.RentaCar.Mapper;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Model.User;
import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Dto.UserDto;
@Component
public class MapperSrvRentImpl implements MapperServices< RentDto, Rent>{
	
	//@Autowired private MapperServices<CarDto, Car> mapperCar;
	//@Autowired private MapperServices<UserDto, User> mapperUser;
	
	@Override
	public RentDto mapToDto(Rent entity) {	
		
		final RentDto rentDto = new RentDto();
		
		rentDto.setCar(entity.getCar());
		rentDto.setFinalDate(entity.getFinalDate());
		rentDto.setIdRent(entity.getIdRent());
		rentDto.setInitDate(entity.getInitDate());
		rentDto.setPrice(entity.getPrice());
		rentDto.setUser(entity.getUser());
		
		return rentDto;
	}

	@Override
	public Rent mapToEntity(RentDto dto)  {
		
		final Rent rent = new Rent();		
		
		rent.setCar(dto.getCar());
		rent.setFinalDate(dto.getFinalDate());
		rent.setIdRent(dto.getIdRent());
		rent.setInitDate(dto.getInitDate());
		rent.setPrice(dto.getPrice());
		rent.setUser(dto.getUser());
		
			
		
		return rent;
	}

	@Override
	public List<RentDto> mapListToDto(List<Rent> listUser) {
		
		final List<RentDto> listRentDto= new ArrayList<>();
		listUser.forEach((b)-> {
			final RentDto rentDto = mapToDto(b);
			listRentDto.add(rentDto);		
		});
		return listRentDto;
	}

	@Override
	public Page<RentDto> mapPageToDto(Page<Rent> pageEntity) {
		return pageEntity.map(b-> mapToDto(b));		
	}
}

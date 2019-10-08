package com.curso.RentaCar.Mapper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;
import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Model.Rent;

@Component
public class MapperSrvRentImpl implements MapperServices< RentDto, Rent>{
	

	
	
	@Override
	public RentDto mapToDto(Rent entity) {	
		
		final RentDto rentDto = new RentDto();
		if(Optional.ofNullable(entity).isPresent()) {
		rentDto.setCar(entity.getCar());
		rentDto.setUser(entity.getUser());
		rentDto.setFinalDate(entity.getFinalDate().toString());
		rentDto.setIdRent(entity.getIdRent());
		rentDto.setInitDate(entity.getInitDate().toString());
		rentDto.setPrice(entity.getPrice());
		
		}
		return rentDto;
	}

	@Override
	public Rent mapToEntity(RentDto dto)  {
		
		final Rent rent = new Rent();		
		if(Optional.ofNullable(dto).isPresent()){
		rent.setCar(dto.getCar());
		rent.setFinalDate(LocalDate.parse(dto.getFinalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		rent.setIdRent(dto.getIdRent());
		rent.setInitDate(LocalDate.parse(dto.getInitDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		rent.setPrice(dto.getPrice());
		rent.setUser(dto.getUser());
		
		}
		
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

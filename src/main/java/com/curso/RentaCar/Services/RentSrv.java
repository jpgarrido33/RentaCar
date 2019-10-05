package com.curso.RentaCar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Model.Rent;

public interface RentSrv {

Rent createRent(Integer idUser, Integer idCar, RentDto rentDto) ;
	
	void deleteRent(Integer idRent);
	
	Optional<Rent> getRentService(Integer idUser, Integer idCar, Integer idRent);
	
	Page<Rent> getAllRent(Integer idUser, Integer idCar, Pageable pageable);
	
	Rent updateRent(Integer idRent, RentDto rentDto);

	List<RentDto> getListRent(List<Rent> rents);
}

package com.curso.RentaCar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.RentNotFoundException;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Model.User;

public interface RentSrv {

Rent createRent(Integer idUser, Integer idCar, RentDto rentDto) throws CarNotFoundException, UserNotFoundException ;
	
	void deleteRent(Integer idRent) throws RentNotFoundException;
	
	Rent getRentService( Integer idRent) throws RentNotFoundException;
	
	Page<Rent> getAllRent( Pageable pageable);
	
	Rent updateRent(Integer idRent, RentDto rentDto) throws RentNotFoundException;

	List<RentDto> getListRent(List<Rent> rents);


}

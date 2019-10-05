package com.curso.RentaCar.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Model.Rent;

public class RentSrvImpl implements RentSrv {

	@Override
	public Rent createRent(Integer idUser, Integer idCar, RentDto rentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteRent(Integer idRent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Rent getRentService(Integer idUser, Integer idCar, Integer idRent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<Rent> getAllRent(Integer idUser, Integer idCar, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rent updateRent(Integer idRent, RentDto rentDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RentDto> getListRent(List<Rent> rents) {
		// TODO Auto-generated method stub
		return null;
	}

}

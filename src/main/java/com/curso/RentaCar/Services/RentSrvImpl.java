package com.curso.RentaCar.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.RentNotFoundException;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Repository.RentRepository;


@Service
public class RentSrvImpl implements RentSrv {

	@Autowired private UserSrv userSrv;
	@Autowired private CarSrv carSrv;
	@Autowired private RentRepository rentRepository;
	@Autowired private MapperServices<RentDto, Rent> mapper;
	
	@Override
	public Rent createRent(Integer idUser, Integer idCar, RentDto rentDto) throws CarNotFoundException, UserNotFoundException {
		final Optional<Rent> rent = Optional.ofNullable(mapper.mapToEntity(rentDto));
		if (rent.isPresent()) {
			rent.get().setUser(userSrv.getUser(idUser));
			rent.get().setCar(carSrv.getCar(idCar));
			rent.get().setInitDate(rentDto.getInitDate());
			rent.get().setFinalDate(rentDto.getFinalDate());
			rent.get().setPrice(rentDto.getPrice());
			rentRepository.save(rent.get());			
		}
		return rent.get();
	}
	
	@Override
	public Rent getRentService( Integer idRent) throws RentNotFoundException {
		Optional<Rent> rent=Optional.ofNullable(rentRepository.findById(idRent)).orElseThrow(RentNotFoundException::new);
		return rent.get();
	}
	
	@Override
	public Page<Rent> getAllRent(Pageable pageable) {
	
		return rentRepository.findAll (pageable);
	}

	@Override
	public void deleteRent(Integer idRent) throws RentNotFoundException {
				
		rentRepository.delete(Optional.ofNullable(this.getRentService(idRent)).orElseThrow(RentNotFoundException::new));
	}

	


	@Override
	public Rent updateRent(Integer idRent, RentDto rentDto) throws RentNotFoundException{
		Rent rent =this.getRentService(idRent);
		rent.setInitDate(rentDto.getInitDate());
		rent.setFinalDate(rentDto.getFinalDate());
		rent.setPrice(rentDto.getPrice());

		return rentRepository.save(rent);
	}

	@Override
	public List<RentDto> getListRent(List<Rent> rents) {
		final List<RentDto> listRentDto = new ArrayList<>();
		rents.forEach(b->{
			listRentDto.add(mapper.mapToDto(b));				
		});
		return listRentDto;
	}



}

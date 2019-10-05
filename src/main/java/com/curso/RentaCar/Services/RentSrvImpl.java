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
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Repository.RentRepository;


@Service
public class RentSrvImpl implements RentSrv {

	@Autowired private UserSrv userSrv;
	@Autowired private CarSrv carSrv;
	@Autowired private RentRepository rentRepository;
	@Autowired private MapperServices<RentDto, Rent> mapper;
	
	@Override
	public Rent createRent(Integer idUser, Integer idCar, RentDto rentDto) {
		final Optional<Rent> rent = Optional.ofNullable(mapper.mapToEntity(rentDto));
		if (rent.isPresent()) {
			rent.get().setUser(userSrv.getUser(idUser));
			rent.get().setCar(carSrv.getCar(idCar));
			rent.get().setInitDate(rentDto.getInitDate());
			rent.get().setFinalDate(rentDto.getFinalDate());
			rent.get().setDateCreatedRent(new Date());
			rentRepository.save(rent.get());			
		}
		return rent.get();
	}

	@Override
	public void deleteRent(Integer idRent) {
				
		rentRepository.deleteById(idRent);
	}

	
//	@Override
//	public Page<Rent> getAllRent(Integer idUser, Integer idCar, Pageable pageable) {
//	
//		return rentRepository.findByUserIdAndCarI(idUser, idCar, pageable);
//	}

	@Override
	public Rent updateRent(Integer idRent, RentDto rentDto) {
		final Rent rent =rentRepository.findById(idRent).orElse(null);
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

	@Override
	public Page<Rent> getRentService(Integer idUser, Integer idCar, Integer idRent, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}

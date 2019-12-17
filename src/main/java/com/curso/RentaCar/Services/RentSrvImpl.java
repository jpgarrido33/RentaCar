package com.curso.RentaCar.Services;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Exception.CarNotFoundException;
import com.curso.RentaCar.Exception.RentNotFoundException;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Model.User;
import com.curso.RentaCar.Repository.RentRepository;


@Service
public class RentSrvImpl implements RentSrv {

	@Autowired private UserSrv userSrv;
	@Autowired private CarSrv carSrv;
	@Autowired private RentRepository rentRepository;
	@Autowired private MapperServices<RentDto, Rent> mapper;
	@Autowired private MapperServices<CarDto, Car> mapperCar;
	@Autowired private MapperServices<UserDto, User> mapperUser;
	
	
	@Override
	public Rent createRent(Integer idUser, Integer idCar, RentDto rentDto) throws CarNotFoundException, UserNotFoundException {
		
		if(userSrv.getUser(idUser)==null) {
			
			throw new UserNotFoundException();
		}
		else if(carSrv.getCar(idCar)==null){
			
			throw new CarNotFoundException();
			
		}
		
		Rent rent=new Rent();
		rent.setUser(userSrv.getUser(idUser));
		rent.setCar(carSrv.getCar(idCar));
		rent.setInitDate(LocalDate.parse(rentDto.getInitDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		rent.setFinalDate(LocalDate.parse(rentDto.getFinalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		rent.setPrice(rentDto.getPrice());
		rentRepository.save(rent);			
	
	return rent;
		

	}
	
	@Override
	public Rent getRentService( Integer idRent) throws RentNotFoundException {
		
		Rent rent=rentRepository.findById(idRent).orElseThrow(RentNotFoundException::new); // corregir que al borrar un usuario, no de error al mostrar listado alquileres
		
		return rent;
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
		rent.setInitDate(LocalDate.parse(rentDto.getInitDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
		rent.setFinalDate(LocalDate.parse(rentDto.getFinalDate(), DateTimeFormatter.ofPattern("yyyy-MM-dd")));
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

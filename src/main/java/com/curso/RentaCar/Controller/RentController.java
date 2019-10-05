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
import org.springframework.web.bind.annotation.RestController;
import com.curso.RentaCar.Dto.RentDto;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Services.RentSrv;

@RestController
@RequestMapping("/rent")
public class RentController {
	
	@Autowired private RentSrv rentSrv;
	@Autowired private MapperServices<RentDto, Rent> mapper;
	

	@GetMapping
	public Page<RentDto> getAllR(@PathVariable("idUser") Integer idUser,@PathVariable("idCar") Integer idCar, 
			@PageableDefault(page = 0, value = 10) Pageable pageable) {
		return mapper.mapPageToDto(rentSrv.getAllRent(idUser, idCar, pageable));
	}
	
	@GetMapping("/{idRent}")
	public Page<RentDto> getRent(@PathVariable("idUser") Integer idUser, @PathVariable("idCar") Integer idCar,
			@PathVariable("idRent") Integer idRent,Pageable pageable) {
		return mapper.mapPageToDto(rentSrv.getRentService(idUser, idCar, idRent, pageable));
	}
	
	@PostMapping
	public RentDto newRent(@PathVariable("idUser") Integer idUser,
			@PathVariable("idCar") Integer idCar, @RequestBody RentDto rentDto) {
		return mapper.mapToDto(rentSrv.createRent(idUser, idCar, rentDto));
	}
	@PutMapping("/{idRent}")
	public RentDto updateRent (@PathVariable("idRent") Integer idRent,@RequestBody RentDto rentDto) {
		
		return mapper.mapToDto(rentSrv.updateRent(idRent, rentDto));
	}

	@DeleteMapping("/{idRent}")
	
	public void deleteRent(@PathVariable("idRent") Integer idRent) {
		rentSrv.deleteRent(idRent);
	}
}
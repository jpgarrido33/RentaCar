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

import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Exception.UpdateErrorException;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.User;
import com.curso.RentaCar.Services.UserSrv;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired private UserSrv userSrv;
	@Autowired private MapperServices<UserDto, User> mapper;
	
	@GetMapping
	public Page<UserDto> getAllUser(@PageableDefault(page = 0, value = 10) Pageable pageable) {
		return mapper.mapPageToDto(userSrv.getListUser(pageable));
	}
	
	@GetMapping("/{idUser}")
	public UserDto getUser(@PathVariable("idUser") Integer idUser){
		
		return  mapper.mapToDto(userSrv.getUser(idUser));
	
	}
	
	@PostMapping
	public UserDto newUser(@RequestBody UserDto userDto) {
		return mapper.mapToDto(userSrv.createUser(userDto));
	}
	@PutMapping("/{idUser}")
	public UserDto updateUser (@PathVariable("idUser") Integer idUser,@RequestBody UserDto userDto) {
		return mapper.mapToDto(userSrv.updateUser(idUser, userDto));
	}

	@DeleteMapping("/{idUser}")
	
	public void deleteRent(@PathVariable("idUser") Integer idUser) {
		userSrv.deleteUser(idUser);
	}
}

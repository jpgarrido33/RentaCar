package com.curso.RentaCar.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Model.Rent;
import com.curso.RentaCar.Model.User;

public interface UserSrv {
	
User createUser(UserDto userDto) ;
	
	User getUser(Integer idUser) throws UserNotFoundException;
	
	Page<User> getListUser(Pageable pageable);
	
	void deleteUser(Integer idUser) throws UserNotFoundException;
	
	User updateUser(Integer idUser, UserDto userDto) throws UserNotFoundException;

	List<Rent> getRentOfUser(Integer idUser) throws UserNotFoundException;
	
	

}

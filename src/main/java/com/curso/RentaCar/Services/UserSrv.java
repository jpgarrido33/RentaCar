package com.curso.RentaCar.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Model.User;

public interface UserSrv {
	
User createUser(UserDto userDto) ;
	
	User getUser(Integer idUser);
	
	Page<User> getListUser(Pageable pageable);
	
	void deleteUser(Integer idUser);
	
	User updateUser(Integer idUser, UserDto userDto);
	
	List<?> getListRentUser(Integer idUser, Pageable pageable);

}
package com.curso.RentaCar.Services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Model.User;

public class UserSrvImpl implements UserSrv {

	@Override
	public User createUser(UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User getUser(Integer idUser) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Page<User> getListUser(Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUser(Integer idUser) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public User updateUser(Integer idUser, UserDto userDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<?> getListRentUser(Integer idUser, Pageable pageable) {
		// TODO Auto-generated method stub
		return null;
	}

}

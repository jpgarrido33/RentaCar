package com.curso.RentaCar.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.curso.RentaCar.Dto.CarDto;
import com.curso.RentaCar.Dto.UserDto;
import com.curso.RentaCar.Exception.UserNotFoundException;
import com.curso.RentaCar.Mapper.MapperServices;
import com.curso.RentaCar.Model.Car;
import com.curso.RentaCar.Model.User;
import com.curso.RentaCar.Repository.UserRepository;

@Service
public class UserSrvImpl implements UserSrv {
	
	@Autowired private UserSrv usersrv;
	@Autowired private UserRepository userRepository;
	@Autowired private MapperServices <UserDto,User> mapper;
	@Autowired private RentSrv rentSrv;
	
	@Override
	
	public User  createUser(UserDto userDto) {
		
		final Optional<User> user = Optional.ofNullable(mapper.mapToEntity(userDto));

		return userRepository.save(user.get());
	}

	@Override
	public User getUser(Integer idUser) throws UserNotFoundException {
		//return userRepository.findById(idUser).orElse(null);
		return Optional.ofNullable(userRepository.findById(idUser).get()).orElseThrow(UserNotFoundException::new);
	}

	@Override
	public Page<User> getListUser(Pageable pageable) {
		
		return userRepository.findAll(pageable);
	}

	@Override
	public void deleteUser(Integer idUser)throws UserNotFoundException {

			
		userRepository.delete(Optional.ofNullable(this.getUser(idUser)).orElseThrow(UserNotFoundException::new));
	}

	@Override
	public  User updateUser(Integer idUser, UserDto userDto) throws UserNotFoundException {
		
		final User user=this.getUser(idUser);
		user.setName(userDto.getName());
		return userRepository.save(user);
	}

//	@Override
//	public List<?> getListRentUser(Integer idUser, Pageable pageable)  {
//		final User user = this.getUser(idUser);
//		return  userRepository.findAll(user,pageable);
//	}

}
